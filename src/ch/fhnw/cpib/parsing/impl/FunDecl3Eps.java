package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IFunDecl3;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IDbcCmd;
import ch.fhnw.cpib.parsing.abs.impl.DbcCmdEps;

public class FunDecl3Eps implements IFunDecl3 {

	@Override
	public IDbcCmd toAbsSyn() {
		return new DbcCmdEps();
	}

	@Override
	public String toString(String indent) {
		return indent + "<Precondition>TRUE</Precondition>\n";
	}

}
