package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.ICExprList;
import ch.fhnw.cpib.parsing.ICmd4;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.ICmd;

public class Cmd4 implements ICmd4 {

	private IToken call;
	private IToken ident;
	private ICExprList exprList;

	public Cmd4(IToken call, IToken ident, ICExprList exprList) {
		this.call = call;
		this.ident = ident;
		this.exprList = exprList;
	}

	//TODO implement
	public ICmd toAbsSyn() {
//		new ch.fhnw.cpib.parsing.abs.impl.ProcDecl(ident,);
		return null; //new ch.fhnw.cpib.parsing.abs.impl.ExprList(new ExprEps(),exprList.toAbsSyn());
//		return new AbsProcCallCmd(ident, exprList.toAbsSyn());
	}

	@Override
	public String toString(String indent) {
		return indent + "<Cmd4>\n" + call.toString(indent + '\t')
				+ ident.toString(indent + '\t') + exprList.toString(indent + '\t')
				+ indent + "</Cmd4>\n";
	}

}
