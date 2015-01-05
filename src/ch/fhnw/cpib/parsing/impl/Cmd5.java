package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.ICmd5;
import ch.fhnw.cpib.parsing.IConcExpr;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.ICmd;
import ch.fhnw.cpib.parsing.abs.impl.CmdIn;

public class Cmd5 implements ICmd5 {
	private IToken debugIn;
	private IConcExpr expr;

	public Cmd5(IToken debugIn, IConcExpr expr) {
		this.debugIn = debugIn;
		this.expr = expr;
	}

	public ICmd toAbsSyn() {
		return new CmdIn(expr.toAbsSyn());
	}

	@Override
	public String toString(String indent) {
		return indent + "<Cmd5>\n" + debugIn.toString(indent + '\t')
				+ expr.toString(indent + '\t') + indent + "</Cmd5>\n";
	}

}
