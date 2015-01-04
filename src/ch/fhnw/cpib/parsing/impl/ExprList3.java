package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IExprList3;
import ch.fhnw.cpib.parsing.IExprList4;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExprList;

public class ExprList3 implements IExprList3 {

	private IExprList4 exprList4;
	private IExprList3 exprList3;

	public ExprList3(IExprList4 exprList4, IExprList3 exprList3) {
		this.exprList4 = exprList4;
		this.exprList3 = exprList3;
	}

	@Override
	public IExprList toAbsSyn() {
		return exprList4.toAbsSyn(exprList3.toAbsSyn());
	}

	@Override
	public String toString(String indent) {
		return indent + "<ExprList3>\n" + exprList4.toString(indent + '\t')
				+ exprList3.toString(indent + '\t') + indent + "</ExprList3>\n";
	}

}
