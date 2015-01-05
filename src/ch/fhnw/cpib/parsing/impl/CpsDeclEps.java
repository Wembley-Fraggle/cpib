package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.ICpsDecl1;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.ICpsDecl;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IDecl;

public class CpsDeclEps implements ICpsDecl1 {

	@Override
	public String toString(String indent) {
		return indent + "<CpsDeclEps/>\n";
	}

	@Override
	public ICpsDecl toAbsSyn() {
		return new ch.fhnw.cpib.parsing.abs.impl.CpsDeclEps();
	}

}
