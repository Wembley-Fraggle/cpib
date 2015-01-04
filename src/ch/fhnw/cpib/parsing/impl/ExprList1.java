package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IExprList1;
import ch.fhnw.cpib.parsing.IExprList2;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExprList;

public class ExprList1 implements IExprList1 {

	private IExprList2 exprList2;

	public ExprList1(IExprList2 exprList2) {
		this.exprList2 = exprList2;
	}

	@Override
	public IExprList toAbsSyn() {
		return exprList2.toAbsSyn();
	}

	@Override
	public String toString(String indent) {
		return indent + "<ExprList1>\n" + exprList2.toString(indent + '\t')
				+ indent + "</ExprList1>\n";
	}

}
