package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.ICmd2;
import ch.fhnw.cpib.parsing.IConcExpr;
import ch.fhnw.cpib.parsing.ICpsCmd;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.ICmd;
import ch.fhnw.cpib.parsing.abs.impl.CmdIf;

public class Cmd2 implements ICmd2 {

	private IToken ifToken;
	private IConcExpr expr;
	private IToken then;
	private ICpsCmd ifBlock;
	private IToken elseif;
	private ICpsCmd elseBlock;
	private IToken end;

	public Cmd2(IToken ifToken, IConcExpr expr, IToken then, ICpsCmd cpsCmd,
			IToken elseif, ICpsCmd cpsCmd2, IToken end) {
		this.ifToken = ifToken;
		this.expr = expr;
		this.then = then;
		this.ifBlock = cpsCmd;
		this.elseif = elseif;
		this.elseBlock = cpsCmd2;
		this.end = end;
	}

	public ICmd toAbsSyn() {
	    return new CmdIf(expr.toAbsSyn(), ifBlock.toAbsSyn(), elseBlock.toAbsSyn());
	}

	@Override
	public String toString(String indent) {
		return indent + "<" + ifToken.getValue() + ">\n"
				+ expr.toString(indent + '\t') 
				+ indent + '\t' + "<" + then.getValue() + ">\n"
				+ ifBlock.toString(indent+"\t\t")
				+ indent + '\t' + "<" + elseif.getValue() + ">\n"
				+ elseBlock.toString(indent+"\t\t")
				+ indent + "</" + end.getValue()
				+ ">\n";
	}

}
