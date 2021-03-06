package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IFactor1;
import ch.fhnw.cpib.parsing.ILiteral;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExpr;

public class Factor1 implements IFactor1 {
	ILiteral literal;

	public Factor1(ILiteral literal) {
		this.literal = literal;
	}

	@Override
	public IExpr toAbsSyn() {
		return literal.toAbsSyn();
	}

	@Override
	public String toString(String indent) {
		return indent + "<Factor1>\n" + literal.toString(indent + '\t') + indent
				+ "</Factor1>\n";
	}
}
