package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.ICCpsDecl;
import ch.fhnw.cpib.parsing.ICDecl;
import ch.fhnw.cpib.parsing.ICpsDecl1;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.ICpsDecl;
import ch.fhnw.cpib.parsing.abs.impl.CpsDecl;

public class CCpsDecl implements ICCpsDecl {
	private ICDecl decl;
	private ICpsDecl1 cpsDecl1;

	public CCpsDecl(ICDecl decl, ICpsDecl1 cpsDecl1) {
		this.decl = decl;
		this.cpsDecl1 = cpsDecl1;
	}

	@Override
	public String toString(String indent) {
		return indent + "<" + decl.toString(indent + '\t') + ">"
				+ cpsDecl1.toString(indent) + "</" + decl.toString(indent + '\t')
				+ ">\n";
	}

	@Override
	public ICpsDecl toAbsSyn() {
	    return new CpsDecl(decl.toAbsSyn(), cpsDecl1.toAbsSyn());
	}
}
