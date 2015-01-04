package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IFunDecl4;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IDbcCmd;
import ch.fhnw.cpib.parsing.abs.impl.DbcCmdEps;

public class FunDecl4Eps implements IFunDecl4 {

	@Override
	public IDbcCmd toAbsSyn() {
		return new DbcCmdEps();
	}

	@Override
	public String toString(String indent) {
		return indent + "<Postcondition>TRUE</Postcondition>\n";
	}

}
