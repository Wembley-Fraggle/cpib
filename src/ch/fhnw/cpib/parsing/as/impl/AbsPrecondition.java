package ch.fhnw.cpib.parsing.as.impl;

import ch.fhnw.cpib.parsing.as.IAbsMother.IAbsPrecondition;

public class AbsPrecondition implements IAbsPrecondition {

	private IAbsExpr expr;

	public AbsPrecondition(IAbsExpr absSyn) {
		this.expr = absSyn;
	}

	@Override
	public String toString(String indent) {
		// TODO Auto-generated method stub
		if (expr != null)
			return indent + "<Precondition>" + expr.toString(indent)
					+ "</Precondition>\n";
		else
			return indent + "<Precondition>true</Precondition>\n";
	}

}
