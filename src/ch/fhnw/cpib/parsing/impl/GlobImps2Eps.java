package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IGlobImps2;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IGlobImp;

public class GlobImps2Eps implements IGlobImps2 {

	@Override
	public String toString(String indent) {
		return indent + "<GlobImps2Eps/>\n";
	}

	@Override
	public IGlobImp toAbsSyn(IGlobImp absSyn) {
		return absSyn;
	}

}
