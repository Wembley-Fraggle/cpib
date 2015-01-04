package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.ICpsStoDecl2;
import ch.fhnw.cpib.parsing.IStoDecl;

public class CpsStoDecl2 implements ICpsStoDecl2 {

	private IToken semi;
	private IStoDecl stoDecl;

	public CpsStoDecl2(IToken semi, IStoDecl stoDecl) {
		this.semi = semi;
		this.stoDecl = stoDecl;
	}

	@Override
	public String toString(String indent) {
		return indent + stoDecl.toString(indent);
	}

}
