package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IProgParam;
import ch.fhnw.cpib.parsing.IProgParamList4;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IParam;

public class ProgParamList4 implements IProgParamList4 {

	@SuppressWarnings("unused")
	private IToken comma;
	private IProgParam progParam;

	public ProgParamList4(IToken comma, IProgParam progParam) {
		this.comma = comma;
		this.progParam = progParam;
	}

	@Override
	public String toString(String indent) {
		return indent + "<ProgParamList4>\n" + progParam.toString(indent + '\t')
				+ indent + "</ProgParamList4>\n";
	}

	@Override
	public IParam toAbsSyn(IParam iParam) {
		return progParam.toAbsSyn(iParam);
	}

}
