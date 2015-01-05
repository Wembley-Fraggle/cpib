package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IParamList3;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IParam;

public class ParamList3Eps implements IParamList3 {

	@Override
	public String toString(String indent) {
		return indent + "<ParamList3Eps/>\n";
	}

	@Override
	public IParam toAbsSyn(IParam absSyn) {
		return absSyn;
	}

}
