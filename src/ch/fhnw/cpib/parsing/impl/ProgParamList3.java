package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IProgParamList3;
import ch.fhnw.cpib.parsing.IProgParamList4;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IParam;

public class ProgParamList3 implements IProgParamList3 {

	private IProgParamList4 progParamList4;
	private IProgParamList3 progParamList3;

	public ProgParamList3(IProgParamList4 progParamList4,
			IProgParamList3 progParamList3) {
		this.progParamList4 = progParamList4;
		this.progParamList3 = progParamList3;
	}

	@Override
	public String toString(String indent) {
		return indent + "<ProgParamList3>\n"
				+ progParamList4.toString(indent + '\t')
				+ progParamList3.toString(indent + '\t') + indent
				+ "</ProgParamList3>\n";
	}

	@Override
	public IParam toAbsSyn(IParam iParam) {
		return progParamList3.toAbsSyn(progParamList4.toAbsSyn(iParam));
	}

}
