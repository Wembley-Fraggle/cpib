package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IGlobImps1;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IGlobImp;

public class GlobImps1Eps implements IGlobImps1 {

	@Override
	public String toString(String indent) {
		return indent + "<GlobalImps1Eps/>\n";
	}

	@Override
	public IGlobImp toAbsSyn(IGlobImp absSyn) {
		return absSyn;
	}

}
