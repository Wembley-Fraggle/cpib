package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IFactor;
import ch.fhnw.cpib.parsing.IMultopr;
import ch.fhnw.cpib.parsing.ITerm311;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExpr;
import ch.fhnw.cpib.parsing.abs.impl.ExprDyadic;

public class Term311 implements ITerm311 {

	private IMultopr multopr;
	private IFactor factor;

	public Term311(IMultopr multopr, IFactor factor) {
		this.multopr = multopr;
		this.factor = factor;
	}

	@Override
	public IExpr toAbsSyn(IExpr expr) {
		return new ExprDyadic(multopr.toAbsSyn(), expr, factor.toAbsSyn());
	}

	@Override
	public String toString(String indent) {
		return indent + "<Term311>\n" + multopr.toString(indent + '\t')
				+ factor.toString(indent + '\t') + indent + "</Term311>\n";
	}

}
