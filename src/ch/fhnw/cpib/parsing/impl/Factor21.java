package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IFactor21;
import ch.fhnw.cpib.parsing.IFactor211;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExpr;

public class Factor21 implements IFactor21 {

	private IFactor211 factor211;

	public Factor21(IFactor211 factor211) {
		this.factor211 = factor211;
	}

	@Override
	public IExpr toAbsSyn(IToken ident) {
		return factor211.toAbsSyn(ident);
	}

	@Override
	public String toString(String indent) {
		return indent + "<Factor21>\n" + factor211.toString(indent + '\t') + indent
				+ "</Factor21>\n";
	}

}
