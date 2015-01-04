package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IConcExpr;
import ch.fhnw.cpib.parsing.IPrecondition;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IDbcCmd;
import ch.fhnw.cpib.parsing.as.IAbsPrecondition;
import ch.fhnw.cpib.parsing.as.impl.AbsPrecondition;

public class Precondition implements IPrecondition {
	private IToken pre;
	private IToken ident;
	private IToken colon;
	private IConcExpr expr;

	public Precondition(IToken pre, IToken ident, IToken colon, IConcExpr expr) {
		this.pre = pre;
		this.ident = ident;
		this.colon = colon;
		this.expr = expr;
	}

	public IAbsPrecondition toAbsSyn() {
		return new AbsPrecondition(expr.toAbsSyn());
	}

	@Override
	public String toString(String indent) {
		return indent + "<" + pre.getValue() + ">\n"
				+ ident.toString(indent + '\t') + expr.toString(indent + '\t') + indent
				+ "</" + pre.getValue() + ">\n";
	}

	@Override
	public IDbcCmd toAbsSyn() {
		// TODO Auto-generated method stub
		return null;
	}
}
