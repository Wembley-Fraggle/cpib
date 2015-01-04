package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.ICExprList;
import ch.fhnw.cpib.parsing.IExprList1;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExprList;

public class ExprList implements ICExprList {

	private IToken lParent;
	private IExprList1 exprList1;
	private IToken rParent;

	public ExprList(IToken lParent, IExprList1 exprList1, IToken rParent) {
		this.lParent = lParent;
		this.exprList1 = exprList1;
		this.rParent = rParent;
	}

	@Override
	public IExprList toAbsSyn() {
		return exprList1.toAbsSyn();
	}

	@Override
	public String toString(String indent) {
		return indent + "<ExprList>\n" + exprList1.toString(indent + '\t') + indent
				+ "</ExprList>\n";
	}

}
