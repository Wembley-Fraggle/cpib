package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IParamList1;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IParam;
import ch.fhnw.cpib.parsing.abs.impl.ParamEps;

public class ParamList1Eps implements IParamList1 {

	@Override
	public IParam toAbsSyn() {
		return new ParamEps();
	}

	@Override
	public String toString(String indent) {
		return indent + "<ParamList1Eps/>\n";
	}

}
