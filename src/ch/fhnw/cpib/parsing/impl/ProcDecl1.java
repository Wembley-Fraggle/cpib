package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IProcDecl1;
import ch.fhnw.cpib.parsing.IProcDecl11;

public class ProcDecl1 implements IProcDecl1 {

	private IProcDecl11 procDecl11;

	public ProcDecl1(IProcDecl11 procDecl11) {
		this.procDecl11 = procDecl11;
	}

	@Override
	public String toString(String indent) {
		return indent + "<ProcDecl1>" + procDecl11.toString(indent + '\t') + indent
				+ "</ProcDecl1>\n";
	}

}
