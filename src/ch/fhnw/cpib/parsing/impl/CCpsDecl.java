package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.ICCpsDecl;
import ch.fhnw.cpib.parsing.ICpsDecl1;
import ch.fhnw.cpib.parsing.ICDecl;

public class CCpsDecl implements ICCpsDecl {
	private ICDecl decl;
	private ICpsDecl1 cpsDecl1;

	public CCpsDecl(ICDecl decl, ICpsDecl1 cpsDecl1) {
		this.decl = decl;
		this.cpsDecl1 = cpsDecl1;
	}

	@Override
	public String toString(String indent) {
		// TODO Auto-generated method stub
		return indent + "<" + decl.toString(indent + '\t') + ">"
				+ cpsDecl1.toString(indent) + "</" + decl.toString(indent + '\t')
				+ ">\n";
	}
}
