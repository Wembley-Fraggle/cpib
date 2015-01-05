package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.ICmd6;
import ch.fhnw.cpib.parsing.IConcExpr;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.ICmd;
import ch.fhnw.cpib.parsing.abs.impl.CmdOut;

public class Cmd6 implements ICmd6 {
	IToken debugOut;
	IConcExpr expr;

	public Cmd6(IToken debugOut, IConcExpr expr) {
		this.debugOut = debugOut;
		this.expr = expr;
	}

	public ICmd toAbsSyn() {
		return new CmdOut(expr.toAbsSyn());
	}

	@Override
	public String toString(String indent) {
		return indent + "<Cmd6>\n" + debugOut.toString(indent + '\t')
				+ expr.toString(indent + '\t') + indent + "</Cmd6>\n";
	}
}
