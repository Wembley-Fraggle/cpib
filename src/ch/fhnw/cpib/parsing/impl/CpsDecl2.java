package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.ICDecl;
import ch.fhnw.cpib.parsing.ICpsDecl2;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.ICpsDecl;
import ch.fhnw.cpib.parsing.abs.impl.CpsDecl;

public class CpsDecl2 implements ICpsDecl2 {

	@SuppressWarnings("unused")
	private IToken semi;
	private ICDecl decl;

	public CpsDecl2(IToken semi, ICDecl decl) {
		this.semi = semi;
		this.decl = decl;
	}

	@Override
	public String toString(String indent) {
		return indent + "<CpsDecl2>\n" + decl.toString(indent + '\t') + indent
				+ "</CpsDecl2>\n";
	}

	@Override
	public ICpsDecl toAbsSyn(ICpsDecl iCpsDecl) {
		return new CpsDecl(decl.toAbsSyn(), iCpsDecl);
	}

}
