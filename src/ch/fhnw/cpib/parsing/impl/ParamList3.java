package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IParamList3;
import ch.fhnw.cpib.parsing.IParamList4;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IParam;

public class ParamList3 implements IParamList3 {

	private IParamList4 paramList4;
	private IParamList3 paramList3;

	public ParamList3(IParamList4 paramList4, IParamList3 paramList3) {
		this.paramList4 = paramList4;
		this.paramList3 = paramList3;
	}

	@Override
	public String toString(String indent) {
		return indent + "<ParamList3>\n" + paramList4.toString(indent + '\t')
				+ paramList3.toString(indent + '\t') + indent + "<ParamList3/>\n";
	}

	@Override
	public IParam toAbsSyn(IParam iParam) {
		return paramList3.toAbsSyn(paramList4.toAbsSyn(iParam));
	}

}
