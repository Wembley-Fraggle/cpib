package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IProcDecl4;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IDbcCmd;
import ch.fhnw.cpib.parsing.abs.impl.DbcCmdEps;

public class ProcDecl4Eps implements IProcDecl4 {

	@Override
	public String toString(String indent) {
		return indent + "<Postcondition>TRUE</Postcondition>\n";
	}

	@Override
	public IDbcCmd toAbsSyn() {
		return new DbcCmdEps();
	}

}
