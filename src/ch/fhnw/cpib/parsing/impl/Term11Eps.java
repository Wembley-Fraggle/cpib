package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.ITerm11;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExpr;

public class Term11Eps implements ITerm11 {

	@Override
	public IExpr toAbsSyn(IExpr left) {
		return left;
	}

	@Override
	public String toString(String indent) {
		return indent + "<Term11Eps/>\n";
	}

}
