package ch.fhnw.cpib.parsing.as.impl;

import ch.fhnw.cpib.parsing.as.IAbsExpr;
import ch.fhnw.cpib.parsing.as.IAbsPostcondition;

public class AbsPostcondition implements IAbsPostcondition {

	private IAbsExpr expr;

	public AbsPostcondition() {
		// TODO Auto-generated constructor stub
	}

	public AbsPostcondition(IAbsExpr absSyn) {
		this.expr = absSyn;
	}

}