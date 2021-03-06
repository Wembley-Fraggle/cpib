package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.ICDecl;
import ch.fhnw.cpib.parsing.IProcDecl;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IDecl;

public class DeclProc implements ICDecl {

	private IProcDecl procDecl;

	public DeclProc(IProcDecl procDecl) {
		this.procDecl = procDecl;
	}

	@Override
	public String toString(String indent) {
		return indent + "<DeclProc>\n" + procDecl.toString(indent + '\t') + indent
				+ "</DeclProc>\n";
	}

	@Override
	public IDecl toAbsSyn() {
		return procDecl.toAbsSyn();
	}

}
