package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.ICmd7;
import ch.fhnw.cpib.parsing.IConcExpr;
import ch.fhnw.cpib.parsing.as.IAbsAssertCmd;
import ch.fhnw.cpib.parsing.as.impl.AbsAssertCmd;

public class Cmd7 implements ICmd7 {
	IToken assertToken;
	IToken identToken;
	IToken colonToken;
	IConcExpr expr;

	public Cmd7(IToken assertToken, IToken identToken, IToken colonToken, IConcExpr expr) {
		this.assertToken = assertToken;
		this.identToken = identToken;
		this.colonToken = colonToken;
		this.expr = expr;
	}

	public IAbsAssertCmd toAbsSyn() {
		return new AbsAssertCmd(expr.toAbsSyn());
	}

	@Override
	public String toString(String indent) {
		return indent + "<Cmd7>\n" 
		        + assertToken.toString(indent + '\t')
		        + identToken.toString(indent + '\t')
		        + colonToken.toString(indent + '\t')
				+ expr.toString(indent + '\t') + indent + "</Cmd7>\n";
	}
}
