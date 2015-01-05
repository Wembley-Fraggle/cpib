package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IGlobImps;
import ch.fhnw.cpib.parsing.IProcDecl11;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IGlobImp;

public class ProcDecl11 implements IProcDecl11 {

	@SuppressWarnings("unused")
	private IToken global;
	private IGlobImps globImps;

	public ProcDecl11(IToken global, IGlobImps globImps) {
		this.global = global;
		this.globImps = globImps;
	}

	@Override
	public String toString(String indent) {
		return indent + "<Global>" + globImps.toString(indent + '\t')
				+ "</Global>\n";
	}

	@Override
	public IGlobImp toAbsSyn() {
		return globImps.toAbsSyn();
	}

}
