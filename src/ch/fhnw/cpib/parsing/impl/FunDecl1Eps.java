package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IFunDecl1;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IGlobImp;
import ch.fhnw.cpib.parsing.abs.impl.GlobImpEps;

public class FunDecl1Eps implements IFunDecl1 {

	@Override
	public IGlobImp toAbsSyn() {
		return new GlobImpEps();
	}

	@Override
	public String toString(String indent) {
		return indent + "<FunDecl1Eps/>\n";
	}

}
