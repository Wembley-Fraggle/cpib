package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IProgParamList;
import ch.fhnw.cpib.parsing.IProgParamList1;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.ICpsDecl;

public class ProgParamList implements IProgParamList {

	private IToken lparen;
	private IProgParamList1 progParamList1;
	private IToken rparen;

	public ProgParamList(IToken lparen, IProgParamList1 progParamList1,
			IToken rparen) {
		this.lparen = lparen;
		this.progParamList1 = progParamList1;
		this.rparen = rparen;
	}

	@Override
	public String toString(String indent) {
		return indent + "<ProgParamList>\n"
				+ progParamList1.toString(indent + '\t') + indent
				+ "</ProgParamList>\n";
	}

	@Override
	public ICpsDecl toAbsSyn() {
		// TODO Auto-generated method stub
		return null;
	}

}
