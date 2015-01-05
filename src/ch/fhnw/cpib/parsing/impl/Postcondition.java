package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IConcExpr;
import ch.fhnw.cpib.parsing.IPostcondition;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IDbcCmd;
import ch.fhnw.cpib.parsing.abs.impl.DbcCmd;

public class Postcondition implements IPostcondition {
	private IToken post;
	private IToken ident;
	@SuppressWarnings("unused")
	private IToken colon;
	private IConcExpr expr;

	public Postcondition(IToken post, IToken ident, IToken colon, IConcExpr expr) {
		this.post = post;
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
		return indent + "<" + post.getValue() + ">\n"
				+ ident.toString(indent + '\t') + expr.toString(indent + '\t') + indent
				+ "</" + post.getValue() + ">\n";
	}

}
