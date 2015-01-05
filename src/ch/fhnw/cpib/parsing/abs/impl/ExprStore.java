package ch.fhnw.cpib.parsing.abs.impl;

import ch.fhnw.cpib.IMLCompiler;
import ch.fhnw.cpib.context.Store;
import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.ILiteralVal;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExpr;
import ch.fhnw.lederer.virtualmachine.IVirtualMachine.CodeTooSmallError;

public final class ExprStore implements IExpr {
	private final IToken ident;
	private final boolean isInit;
	
	public ExprStore(final IToken ident, final boolean isInit) {
		this.ident = ident;
		this.isInit = isInit;
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<ExprStore>\n"
				+ ident.toString(indent + '\t')
				+ indent
				+ "<IsInit>" + isInit + "</IsInit>\n"
				+ indent
				+ "</ExprStore>\n";
	}
	
	@Override
	public int getLine() {
	    return ident.getStart().getCurrentLine();
	}
	
	public Store getStore() {
	    return IMLCompiler.getScope().getStoreTable().getStore(
	            ident.getValue());
	}

    @Override
    public ILiteralVal.Type checkR() throws ContextError {
        ILiteralVal.Type type = IMLCompiler.getScope().getType(
                ident.getValue());
        
        if (type == null) {
            throw new ContextError(
                    "Ident " + ident.getValue() + " not declared",
                    ident.getStart().getCurrentLine());
        } 

        if (isInit) {
            throw new ContextError(
                    "Initialization of "
                            + ident.getValue() 
                            + " found in left part of an assignement",
                    ident.getStart().getCurrentLine());
        }
        
        if (!IMLCompiler.getScope().getStoreTable().getStore(
                ident.getValue()).isInitialized()) {
            throw new ContextError(
                    "Store "
                            + ident.getValue() 
                            + " is not initialized",
                    ident.getStart().getCurrentLine());
        }
        
        return type;
    }

    @Override
    public ILiteralVal.Type checkL(final boolean canInit) throws ContextError {
        ILiteralVal.Type type = IMLCompiler.getScope().getType(
                ident.getValue());
        
        if (type == null) {
            throw new ContextError(
                    "Ident " + ident.getValue() + " not declared",
                    ident.getStart().getCurrentLine());
        } 
        
        Store store = IMLCompiler.getScope().getStoreTable().getStore(
                ident.getValue());
        
        if (isInit) {
            if (canInit) {
                throw new ContextError(
                        "Store can not be initialized here " 
                                + "(loop or inout parameter)!",
                        ident.getStart().getCurrentLine());
            }
            if (store.isInitialized()) {
                throw new ContextError(
                        "Store "
                                + ident.getValue() 
                                + " is already initialized",
                        ident.getStart().getCurrentLine());
            }
            store.initialize();
        } else if (!store.isInitialized()) {
            throw new ContextError(
                    "Store "
                            + ident.getValue() 
                            + " is not initialized",
                    ident.getStart().getCurrentLine());
        } else if (!store.isWriteable()) {
            throw new ContextError(
                    "Store "
                            + ident.getValue() 
                            + " is not writeable",
                    ident.getStart().getCurrentLine());
        }
        
        return type;
    }

    @Override
    public int code(final int loc) throws CodeTooSmallError {
        Store store = IMLCompiler.getScope().getStoreTable().getStore(
                ident.getValue());
        return store.codeLoad(loc);
    }
    
    public int codeRef(final int loc) throws CodeTooSmallError {
    	System.out.println("ident: " + ident.getValue());
        Store store = IMLCompiler.getScope().getStoreTable().getStore(
                ident.getValue());
        return store.codeRef(loc);
    }

    public String getIdent() {
        return ident.getValue();
    }
}
