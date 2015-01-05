package ch.fhnw.cpib.parsing.abs.impl;

import ch.fhnw.cpib.parsing.ILiteralVal;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExpr;
import ch.fhnw.lederer.virtualmachine.IVirtualMachine.CodeTooSmallError;

public final class ExprEps implements IExpr {
	@Override
	public String toString(final String indent) {
		return indent + "<ExprEps/>\n";
	}
	
	@Override
	public int getLine() {
	    return -1;
	}

    @Override
    public ILiteralVal.Type checkR() throws ContextError {
        throw new ContextError(
                "Right part of an assignement can not be empty!",
                -1);
    }
    
    @Override
    public ILiteralVal.Type checkL(final boolean canInit) throws ContextError {
        throw new ContextError(
                "Only stores are allowed in the left part of assignements",
                -1);
    }

    @Override
    public int code(final int loc) throws CodeTooSmallError {
        return loc;
    }
    
    
}
