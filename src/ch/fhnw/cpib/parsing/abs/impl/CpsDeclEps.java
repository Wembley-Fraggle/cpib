package ch.fhnw.cpib.parsing.abs.impl;

import ch.fhnw.cpib.parsing.abs.IAbstSyn.ICpsDecl;
import ch.fhnw.lederer.virtualmachine.IVirtualMachine.CodeTooSmallError;
import ch.fhnw.lederer.virtualmachine.IVirtualMachine.HeapTooSmallError;

public final class CpsDeclEps implements ICpsDecl {
	@Override
	public String toString(final String indent) {
		return indent + "<CpsDeclEps/>\n";
	}
	
	@Override
	public int getLine() {
	    return -1;
	}

    @Override
    public void checkDeclaration() { }

    @Override
    public int code(final int loc) throws CodeTooSmallError {
        return loc;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public void check(final int locals) 
            throws ContextError, HeapTooSmallError { }
}
