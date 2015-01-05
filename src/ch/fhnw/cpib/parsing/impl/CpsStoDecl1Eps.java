package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.ICpsStoDecl1;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.ICpsDecl;


public class CpsStoDecl1Eps implements ICpsStoDecl1 {

	@Override
	public String toString(String indent) {
		return indent + "<CpsStoDecl1Eps/>\n";
	}

	@Override
	public ICpsDecl toAbsSyn() {
	    return new ch.fhnw.cpib.parsing.abs.impl.CpsDeclEps();
	}

}
