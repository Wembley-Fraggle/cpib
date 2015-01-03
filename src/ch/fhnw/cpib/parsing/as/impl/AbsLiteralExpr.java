package ch.fhnw.cpib.parsing.as.impl;

import ch.fhnw.cpib.parsing.ILiteral;
import ch.fhnw.cpib.parsing.as.IAbsExpr;

public class AbsLiteralExpr implements IAbsExpr {

	private ILiteral literal;
	
	public AbsLiteralExpr(ILiteral literal) {
		this.literal = literal;
	}

}
