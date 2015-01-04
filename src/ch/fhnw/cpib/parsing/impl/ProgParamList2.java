package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IProgParam;
import ch.fhnw.cpib.parsing.IProgParamList2;
import ch.fhnw.cpib.parsing.IProgParamList3;

public class ProgParamList2 implements IProgParamList2 {

	private IProgParam progParam;
	private IProgParamList3 progParamList3;

	public ProgParamList2(IProgParam progParam, IProgParamList3 progParamList3) {
		this.progParam = progParam;
		this.progParamList3 = progParamList3;
	}

	@Override
	public String toString(String indent) {
		// TODO Auto-generated method stub
		return indent + "<ProgParamList2>\n" + progParam.toString(indent + '\t')
				+ progParamList3.toString(indent + '\t') + indent
				+ "</ProgParamList2>\n";
	}

}
