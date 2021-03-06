package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.ITerm11;
import ch.fhnw.cpib.parsing.ITerm12;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExpr;

public class Term11 implements ITerm11 {

	private ITerm12 term12;

	public Term11(ITerm12 term12) {
		this.term12 = term12;
	}

	@Override
	public IExpr toAbsSyn(IExpr left) {
		return term12.toAbsSyn(left);
	}

	@Override
	public String toString(String indent) {
		return indent + "<Term11>\n" + term12.toString(indent + '\t') + indent
				+ "</Term11>\n";
	}

}
