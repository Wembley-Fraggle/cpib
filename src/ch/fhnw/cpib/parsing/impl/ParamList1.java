package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IParamList1;
import ch.fhnw.cpib.parsing.IParamList2;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IParam;

public class ParamList1 implements IParamList1 {

	private IParamList2 paramList2;

	public ParamList1(IParamList2 paramList2) {
		this.paramList2 = paramList2;
	}

	@Override
	public IParam toAbsSyn() {
		return paramList2.toAbsSyn();
	}

	@Override
	public String toString(String indent) {
		return indent + "<ParamList1>\n" + paramList2.toString(indent + '\t')
				+ indent + "</ParamList1>\n";
	}

}
