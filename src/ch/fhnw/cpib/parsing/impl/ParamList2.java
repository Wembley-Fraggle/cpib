package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.ICParam;
import ch.fhnw.cpib.parsing.IParamList2;
import ch.fhnw.cpib.parsing.IParamList3;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IParam;

public class ParamList2 implements IParamList2 {

	private ICParam param;
	private IParamList3 paramList3;

	public ParamList2(ICParam param, IParamList3 paramList3) {
		this.param = param;
		this.paramList3 = paramList3;
	}

	@Override
	public IParam toAbsSyn() {
		return paramList3.toAbsSyn(param.toAbsSyn());
	}

	@Override
	public String toString(String indent) {
		return indent + "<ParamList2>\n" + param.toString(indent + '\t')
				+ paramList3.toString(indent + '\t') + indent + "</ParamList2>\n";
	}

}
