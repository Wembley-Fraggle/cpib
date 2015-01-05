package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IFunDecl11;
import ch.fhnw.cpib.parsing.IGlobImps;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IGlobImp;

public class FunDecl11 implements IFunDecl11 {

	private IToken global;
	private IGlobImps globImps;

	public FunDecl11(IToken global, IGlobImps globImps) {
		this.global = global;
		this.globImps = globImps;
	}

	@Override
	public IGlobImp toAbsSyn() {
		return globImps.toAbsSyn();
	}

	@Override
	public String toString(String indent) {
		return indent + "<FunDecl11>\n" + global.toString(indent + '\t')
				+ globImps.toString(indent + '\t') + indent + "</FunDecl11>\n";
	}
}
