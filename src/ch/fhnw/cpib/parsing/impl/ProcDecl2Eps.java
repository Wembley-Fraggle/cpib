package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IProcDecl2;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.ICpsDecl;

public class ProcDecl2Eps implements IProcDecl2 {

	@Override
	public String toString(String indent) {
		return indent + "<ProcDecl2Eps/>\n";
	}

	@Override
	public ICpsDecl toAbsSyn() {
		return new ch.fhnw.cpib.parsing.abs.impl.CpsDeclEps();
	}

}
