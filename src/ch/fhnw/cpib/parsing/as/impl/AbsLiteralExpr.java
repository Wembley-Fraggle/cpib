package ch.fhnw.cpib.parsing.as.impl;

import ch.fhnw.cpib.parsing.ILiteral;
import ch.fhnw.cpib.parsing.as.IAbsMother.IAbsExpr;

public class AbsLiteralExpr implements IAbsExpr {

	private ILiteral literal;
	
	public AbsLiteralExpr(ILiteral literal) {
		this.literal = literal;
	}

	@Override
	public String toString(String ident) {
		// TODO Auto-generated method stub
		return null;
	}

}
