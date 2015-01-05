package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IConcExpr;
import ch.fhnw.cpib.parsing.IFactor5;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExpr;

// TODO Rename to factor 4
public class Factor5 implements IFactor5 {

	@SuppressWarnings("unused")
	private IToken lParent;
	private IConcExpr expr;
	@SuppressWarnings("unused")
	private IToken rParent;

	public Factor5(IToken lParent, IConcExpr expr, IToken rParent) {
		this.lParent = lParent;
		this.expr = expr;
		this.rParent = rParent;
	}

	@Override
	public IExpr toAbsSyn() {
		return expr.toAbsSyn();
	}

	@Override
	public String toString(String indent) {
		return indent + "<Factor4>\n" + expr.toString(indent + '\t') + indent
				+ "</Factor4>\n";
	}

}
