package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IProgram2;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.ICpsDecl;

public class Program2Eps implements IProgram2 {

	@Override
	public String toString(String indent) {
		return indent + "<Program2Eps/>\n";
	}

	@Override
	public ICpsDecl toAbsSyn() {
		return new ch.fhnw.cpib.parsing.abs.impl.CpsDeclEps();
	}

}
