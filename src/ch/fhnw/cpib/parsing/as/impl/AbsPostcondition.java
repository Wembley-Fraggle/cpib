package ch.fhnw.cpib.parsing.as.impl;

import ch.fhnw.cpib.parsing.as.IAbsMother.IAbsExpr;
import ch.fhnw.cpib.parsing.as.IAbsMother.IAbsPostcondition;

public class AbsPostcondition implements IAbsPostcondition {

	private IAbsExpr expr;

	public AbsPostcondition() {
		// TODO Auto-generated constructor stub
	}

	public AbsPostcondition(IAbsExpr absSyn) {
		this.expr = absSyn;
	}

	@Override
	public String toString(String indent) {
		// TODO Auto-generated method stub
		return null;
	}

}
