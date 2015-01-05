package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.ICmd3;
import ch.fhnw.cpib.parsing.ICmd31;
import ch.fhnw.cpib.parsing.IConcExpr;
import ch.fhnw.cpib.parsing.ICpsCmd;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.ICmd;
import ch.fhnw.cpib.parsing.abs.impl.CmdWhile;

public class Cmd3 implements ICmd3 {

	private IToken whileToken;
	private IConcExpr expr;
	private ICmd31 optInvariant;
	@SuppressWarnings("unused")
	private IToken doToken;
	private ICpsCmd cpsCmd;
	private IToken endWhileToken;


	public Cmd3(IToken whileToken, IConcExpr expr, ICmd31 cmd31, IToken doToken,
			ICpsCmd cpsCmd, IToken endWhileToken) {
		this.whileToken = whileToken;
		this.expr = expr;
		this.optInvariant = cmd31;
		this.doToken = doToken;
		this.cpsCmd = cpsCmd;
		this.endWhileToken = endWhileToken;
	}

	public ICmd toAbsSyn() {
	    ICmd dbcCmd = optInvariant.toAbsSyn();
	    return new CmdWhile(expr.toAbsSyn(), cpsCmd.toAbsSyn(), dbcCmd);
	}

	@Override
	public String toString(String indent) {
		return indent + "<" + whileToken.getValue() + ">\n" + expr.toString(indent + '\t')
				+ optInvariant.toString(indent + '\t') + cpsCmd.toString(indent + '\t')
				+ indent + "<"+ endWhileToken.getValue() + ">\n";
	}
}
