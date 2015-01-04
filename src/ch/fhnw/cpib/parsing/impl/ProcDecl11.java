package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IGlobImps;
import ch.fhnw.cpib.parsing.IProcDecl11;

public class ProcDecl11 implements IProcDecl11 {

	private IToken global;
	private IGlobImps globImps;

	public ProcDecl11(IToken global, IGlobImps globImps) {
		this.global = global;
		this.globImps = globImps;
	}

	@Override
	public String toString(String indent) {
		// TODO Auto-generated method stub
		return indent + "<Global>" + globImps.toString(indent + '\t')
				+ "</Global>\n";
	}

}
