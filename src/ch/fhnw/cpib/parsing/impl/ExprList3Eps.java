package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IExprList3;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExprList;
import ch.fhnw.cpib.parsing.abs.impl.ExprListEps;

public class ExprList3Eps implements IExprList3 {

	@Override
	public IExprList toAbsSyn() {
		return new ExprListEps();
	}

	@Override
	public String toString(String indent) {
		return indent + "<ExprList3Eps/>\n";
	}

}
