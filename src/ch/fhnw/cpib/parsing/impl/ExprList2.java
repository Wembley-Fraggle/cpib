package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IConcExpr;
import ch.fhnw.cpib.parsing.IExprList2;
import ch.fhnw.cpib.parsing.IExprList3;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExprList;
import ch.fhnw.cpib.parsing.abs.impl.ExprList;

public class ExprList2 implements IExprList2 {

	private IConcExpr expr;
	private IExprList3 exprList3;

	public ExprList2(IConcExpr expr, IExprList3 exprList3) {
		this.expr = expr;
		this.exprList3 = exprList3;
	}

	@Override
	public IExprList toAbsSyn() {
		return new ExprList(expr.toAbsSyn(), exprList3.toAbsSyn());
	}

	@Override
	public String toString(String indent) {
		return indent + "<ExprList2>\n" + expr.toString(indent + '\t')
				+ exprList3.toString(indent + '\t') + indent + "</ExprList2>\n";
	}

}
