package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IProgram4;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IDbcCmd;
import ch.fhnw.cpib.parsing.abs.impl.DbcCmdEps;

public class Program4Eps implements IProgram4 {

	@Override
	public String toString(String indent) {
		return indent + "<postcondition>TRUE</postcondition>\n";
	}

	@Override
	public IDbcCmd toAbsSyn() {
		return new DbcCmdEps();
	}

}
