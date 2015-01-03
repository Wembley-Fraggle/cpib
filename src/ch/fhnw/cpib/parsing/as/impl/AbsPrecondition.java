package ch.fhnw.cpib.parsing.as.impl;

import ch.fhnw.cpib.parsing.as.IAbsMother.IAbsExpr;
import ch.fhnw.cpib.parsing.as.IAbsPrecondition;

public class AbsPrecondition implements IAbsPrecondition {
	
	private IAbsExpr expr;

	public AbsPrecondition() {
		// TODO Auto-generated constructor stub
	}
	
	public AbsPrecondition(IAbsExpr absSyn) {
		this.expr = absSyn;
	}

}
