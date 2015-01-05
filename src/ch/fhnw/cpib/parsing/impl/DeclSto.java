package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.ICDecl;
import ch.fhnw.cpib.parsing.IStoDecl;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IDecl;

public class DeclSto implements ICDecl {

	private IStoDecl stoDecl;

	public DeclSto(IStoDecl stoDecl) {
		this.stoDecl = stoDecl;
	}

	@Override
	public String toString(String indent) {
		return indent + "<DeclSto>\n" + stoDecl.toString(indent + '\t') + indent
				+ "</DeclSto>\n";
	}

	@Override
	public IDecl toAbsSyn() {
		return stoDecl.toAbsSyn();
	}

}
