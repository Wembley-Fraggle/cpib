package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IFunDecl2;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.ICpsDecl;

public class FunDecl2Eps implements IFunDecl2 {

	@Override
	public ICpsDecl toAbsSyn() {
		return new ch.fhnw.cpib.parsing.abs.impl.CpsDeclEps();
	}

	@Override
	public String toString(String indent) {
		return indent + "<FunDecl2Eps/>\n";
	}

}
