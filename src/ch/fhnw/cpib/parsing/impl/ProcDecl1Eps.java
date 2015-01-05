package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IProcDecl1;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IGlobImp;
import ch.fhnw.cpib.parsing.abs.impl.GlobImpEps;

public class ProcDecl1Eps implements IProcDecl1 {

	@Override
	public String toString(String indent) {
		return indent + "<ProcDecl1Eps/>\n";
	}

	@Override
	public IGlobImp toAbsSyn() {
		return new GlobImpEps();
	}

}
