package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IProgParam;
import ch.fhnw.cpib.parsing.IProgParamList4;

public class ProgParamList4 implements IProgParamList4 {

	private IToken comma;
	private IProgParam progParam;

	public ProgParamList4(IToken comma, IProgParam progParam) {
		this.comma = comma;
		this.progParam = progParam;
	}

	@Override
	public String toString(String indent) {
		return indent + "<ProgParamList4>\n" + comma.getValue()
				+ progParam.toString(indent + '\t') + indent + "</ProgParamList4>/n";
	}

}
