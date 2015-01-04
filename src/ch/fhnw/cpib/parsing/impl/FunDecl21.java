package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.ICpsStoDecl;
import ch.fhnw.cpib.parsing.IFunDecl21;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.ICpsDecl;

public class FunDecl21 implements IFunDecl21 {
	IToken local;
	ICpsStoDecl cpsStoDecl;

	public FunDecl21(IToken local, ICpsStoDecl cpsStoDecl) {
		this.local = local;
		this.cpsStoDecl = cpsStoDecl;
	}

	@Override
	public ICpsDecl toAbsSyn() {
		return cpsStoDecl.toAbsSyn();
	}

	@Override
	public String toString(String indent) {
		return indent + "<FunDecl21>\n" + local.toString(indent + '\t')
				+ cpsStoDecl.toString(indent + '\t') + indent + "</FunDecl21>\n";
	}

}
