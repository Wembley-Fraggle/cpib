package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IProgram3;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IDbcCmd;
import ch.fhnw.cpib.parsing.abs.impl.DbcCmdEps;

public class Program3Eps implements IProgram3 {

	@Override
	public String toString(String indent) {
		return indent + "<precondition>TRUE</precondition>\n";
	}

	@Override
	public IDbcCmd toAbsSyn() {
		return new DbcCmdEps();
	}

}
