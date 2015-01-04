package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.ICDecl;
import ch.fhnw.cpib.parsing.IFunDecl;

public class DeclFun implements ICDecl {

	private IFunDecl funDecl;

	public DeclFun(IFunDecl funDecl) {
		this.funDecl = funDecl;
	}

	@Override
	public String toString(String indent) {
		return indent + "<DeclFun>\n" + funDecl.toString(indent + '\t') + indent
				+ "</DeclFun>\n";
	}

}
