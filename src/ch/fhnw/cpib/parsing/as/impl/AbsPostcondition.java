package ch.fhnw.cpib.parsing.as.impl;

import ch.fhnw.cpib.parsing.as.IAbsMother.IAbsPostcondition;

public class AbsPostcondition implements IAbsPostcondition {

	private IAbsExpr expr;

	public AbsPostcondition(IAbsExpr absSyn) {
		this.expr = absSyn;
	}

	@Override
	public String toString(String indent) {
		// TODO Auto-generated method stub
		if (expr != null)
			return indent + "<Postcondition>" + expr.toString(indent)
					+ "</Postcondition>\n";
		else
			return indent + "<Postcondition>true</Postcondition>\n";
	}

}
