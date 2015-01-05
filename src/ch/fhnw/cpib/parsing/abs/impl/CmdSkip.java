package ch.fhnw.cpib.parsing.abs.impl;

import ch.fhnw.cpib.parsing.abs.IAbstSyn.ICmd;
import ch.fhnw.lederer.virtualmachine.IVirtualMachine.CodeTooSmallError;

public final class CmdSkip implements ICmd {
	
	public CmdSkip() {
	}

	@Override
    public String toString(final String indent) {
		return indent
				+ "<CmdSkip>\n"
				+ indent
				+ "</CmdSkip>\n";
	}
	
	@Override
	public int getLine() {
	    return -1;
	}

    @Override
    public void check(final boolean canInit) throws ContextError {
    }

    @Override
    public int code(final int loc) throws CodeTooSmallError {
        return loc;
    }
}
