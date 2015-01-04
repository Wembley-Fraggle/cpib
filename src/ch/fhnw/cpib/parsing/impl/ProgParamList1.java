package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IProgParamList1;
import ch.fhnw.cpib.parsing.IProgParamList2;

public class ProgParamList1 implements IProgParamList1 {

	private IProgParamList2 progParamList2;

	public ProgParamList1(IProgParamList2 progParamList2) {
		this.progParamList2 = progParamList2;
	}

	@Override
	public String toString(String indent) {
		// TODO Auto-generated method stub
		return indent + "<ProgParamList1>\n"
				+ progParamList2.toString(indent + '\t') + indent
				+ "</ProgParamList1>\n";
	}

}
