package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IRelopr;
import ch.fhnw.cpib.parsing.ITerm12;
import ch.fhnw.cpib.parsing.ITerm2;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExpr;
import ch.fhnw.cpib.parsing.abs.impl.ExprDyadic;

public class Term12 implements ITerm12 {

	private IRelopr relopr;
	private ITerm2 term2;

	public Term12(IRelopr relopr, ITerm2 term2) {
		this.relopr = relopr;
		this.term2 = term2;
	}

	@Override
	public IExpr toAbsSyn(IExpr left) {
		return new ExprDyadic(relopr.toAbsSyn(), left, term2.toAbsSyn());
	}

	@Override
	public String toString(String indent) {
		return indent + "<Term12>\n" + relopr.toString(indent + '\t')
				+ term2.toString(indent + '\t') + indent+"</Term12>\n";
	}

}
