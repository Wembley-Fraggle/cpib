package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.ICParam;
import ch.fhnw.cpib.parsing.IParamList4;

public class ParamList4 implements IParamList4 {

	private IToken comma;
	private ICParam param;

	public ParamList4(IToken comma, ICParam param) {
		this.comma = comma;
		this.param = param;
	}

	@Override
	public String toString(String indent) {
		return indent + "<ParamList4>\n" + param.toString(indent + '\t') + indent
				+ "</ParamList4>\n";
	}

}
