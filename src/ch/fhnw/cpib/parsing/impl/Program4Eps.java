package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IProgram4;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IDbcCmd;

public class Program4Eps implements IProgram4 {

	@Override
	public String toString(String indent) {
		return indent + "<postcondition>TRUE</postcondition>\n";
	}

	@Override
	public IDbcCmd toAbsSyn() {
		// TODO Auto-generated method stub
		return null;
	}

}
