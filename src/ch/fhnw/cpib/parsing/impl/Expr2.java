package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IBoolopr;
import ch.fhnw.cpib.parsing.IExpr2;
import ch.fhnw.cpib.parsing.ITerm1;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExpr;
import ch.fhnw.cpib.parsing.abs.impl.ExprDyadic;

public class Expr2 implements IExpr2 {

	private IBoolopr boolopr;
	private ITerm1 term1;

	public Expr2(IBoolopr boolopr, ITerm1 term1) {
		this.boolopr = boolopr;
		this.term1 = term1;
	}

	@Override
	public IExpr toAbsSyn(IExpr expr) {
		return new ExprDyadic(boolopr.toAbsSyn(), expr, term1.toAbsSyn());
	}

	@Override
	public String toString(String indent) {
		return indent + "<Expr2>\n" + boolopr.toString(indent + '\t')
				+ term1.toString(indent + '\t') + indent + "</Expr2>\n";
	}

}
