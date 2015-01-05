package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.ICpsStoDecl;
import ch.fhnw.cpib.parsing.IProcDecl21;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.ICpsDecl;

public class ProcDecl21 implements IProcDecl21 {

	private IToken local;
	private ICpsStoDecl cpsStoDecl;

	public ProcDecl21(IToken local, ICpsStoDecl cpsStoDecl) {
		this.local = local;
		this.cpsStoDecl = cpsStoDecl;
	}

	@Override
	public String toString(String indent) {
		return indent + "<" + local.getValue() + ">" + cpsStoDecl.toString(indent)
				+ "</" + local.getValue() + ">\n";
	}

	@Override
	public ICpsDecl toAbsSyn() {
		return cpsStoDecl.toAbsSyn();
	}

}
