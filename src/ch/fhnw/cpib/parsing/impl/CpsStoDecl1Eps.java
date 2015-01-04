package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.ICpsStoDecl1;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.ICpsDecl;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IStoreDecl;
import ch.fhnw.cpib.parsing.abs.impl.CpsDecl;

public class CpsStoDecl1Eps implements ICpsStoDecl1 {

	@Override
	public String toString(String indent) {
		return indent + "<CpsStoDecl1Eps/>\n";
	}

	@Override
	public ICpsDecl toAbsSyn(IStoreDecl absSyn) {
		return new CpsDecl(absSyn, new ch.fhnw.cpib.parsing.abs.impl.CpsDeclEps());
	}

}
