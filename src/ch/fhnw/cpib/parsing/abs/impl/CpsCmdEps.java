package ch.fhnw.cpib.parsing.abs.impl;

import ch.fhnw.cpib.parsing.abs.IAbstSyn.ICpsCmd;
import ch.fhnw.lederer.virtualmachine.IVirtualMachine.CodeTooSmallError;

public final class CpsCmdEps implements ICpsCmd {
    
    public CpsCmdEps() {
    }
    
	@Override
    public String toString(final String indent) {
		return indent + "<CpsCmdEps/>\n";
	}
	
	@Override
	public int getLine() {
	    return -1;
	}

    @Override
    public void check(final boolean canInit) { }

    @Override
    public int code(final int loc) throws CodeTooSmallError {
        return loc;
    }
}
