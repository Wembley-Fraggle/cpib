package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IProcDecl3;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IDbcCmd;
import ch.fhnw.cpib.parsing.abs.impl.DbcCmdEps;

public class ProcDecl3Eps implements IProcDecl3 {

	@Override
	public String toString(String indent) {
		return indent + "<Precondition>TRUE</Precondition>\n";
	}

	@Override
	public IDbcCmd toAbsSyn() {
		return new DbcCmdEps();
	}

}
