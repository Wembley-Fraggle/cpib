package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.ICpsDecl;
import ch.fhnw.cpib.parsing.ICpsDecl1;
import ch.fhnw.cpib.parsing.IDecl;

public class CpsDecl implements ICpsDecl {
	private IDecl decl;
	private ICpsDecl1 cpsDecl1;

	public CpsDecl(IDecl decl, ICpsDecl1 cpsDecl1) {
		this.decl = decl;
		this.cpsDecl1 = cpsDecl1;
	}

	@Override
	public String toString(String indent) {
		// TODO Auto-generated method stub
		return indent + "<" + decl.toString() + ">" + cpsDecl1.toString(indent)
				+ "</" + decl.toString() + ">\n";
	}
}
