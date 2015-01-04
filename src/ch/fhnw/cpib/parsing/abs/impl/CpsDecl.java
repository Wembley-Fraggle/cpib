package ch.fhnw.cpib.parsing.abs.impl;

import ch.fhnw.cpib.parsing.abs.IAbstSyn.ICpsDecl;
import ch.fhnw.lederer.virtualmachine.IVirtualMachine.CodeTooSmallError;
import ch.fhnw.lederer.virtualmachine.IVirtualMachine.HeapTooSmallError;

public final class CpsDecl implements ICpsDecl {
	private final IDecl decl;
	private final ICpsDecl cpsDecl;
	
	public CpsDecl(final IDecl decl, final ICpsDecl cpsDecl) {
		this.decl = decl;
		this.cpsDecl = cpsDecl;
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<CpsDecl>\n"
				+ decl.toString(indent + '\t')
				+ cpsDecl.toString(indent + '\t')
				+ indent
				+ "</CpsDecl>\n";
	}
	
	@Override
	public int getLine() {
	    return decl.getLine();
	}

    @Override
    public void check(final int locals) 
            throws ContextError, HeapTooSmallError {
        cpsDecl.check(decl.check(locals));
    }

    @Override
    public void checkDeclaration() throws ContextError, HeapTooSmallError {
        decl.checkDeclaration();
        cpsDecl.checkDeclaration();
    }

    @Override
    public int getCount() {
        return cpsDecl.getCount() + 1;
    }

    @Override
    public int code(final int loc) throws CodeTooSmallError {
        int loc1 = decl.code(loc);
        return cpsDecl.code(loc1);
    }
}
