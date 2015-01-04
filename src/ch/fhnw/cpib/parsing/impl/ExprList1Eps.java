package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IExprList1;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExprList;
import ch.fhnw.cpib.parsing.abs.impl.ExprListEps;

public class ExprList1Eps implements IExprList1 {

	@Override
	public IExprList toAbsSyn() {
		return new ExprListEps();
	}

	@Override
	public String toString(String indent) {
		return indent + "<ExprList1Eps/>\n";
	}
}
