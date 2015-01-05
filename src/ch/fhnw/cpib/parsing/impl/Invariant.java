package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IConcExpr;
import ch.fhnw.cpib.parsing.IInvariant;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IDbcCmd;
import ch.fhnw.cpib.parsing.abs.impl.DbcCmd;

public class Invariant implements IInvariant {

	private IToken inv;
	private IToken ident;
	@SuppressWarnings("unused")
	private IToken colon;
	private IConcExpr expr;

	public Invariant(IToken inv, IToken ident, IToken colon, IConcExpr expr) {
		this.inv = inv;
		this.ident = ident;
		this.colon = colon;
		this.expr = expr;
	}

	@Override
	public IDbcCmd toAbsSyn() {
		return new DbcCmd(ident, expr.toAbsSyn());
	}

	@Override
	public String toString(String indent) {
		return indent + "<" + inv.getValue() + ">\n"
				+ ident.toString(indent + '\t') + expr.toString(indent + '\t') + indent
				+ "</" + inv.getValue() + ">\n";
	}
}
