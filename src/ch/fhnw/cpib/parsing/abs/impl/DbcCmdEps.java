package ch.fhnw.cpib.parsing.abs.impl;

import ch.fhnw.cpib.parsing.abs.IAbstSyn.IDbcCmd;
import ch.fhnw.lederer.virtualmachine.IVirtualMachine.CodeTooSmallError;

public class DbcCmdEps implements IDbcCmd {

	@Override
	public void check(boolean canInit) throws ContextError {
	}

	@Override
	public int code(int loc) throws CodeTooSmallError {
		return loc;
	}

	@Override
	public String toString(String indent) {
		return indent + "<DbcCmdEps/>\n";
	}

	@Override
	public int getLine() {
		return -1;
	}
}
