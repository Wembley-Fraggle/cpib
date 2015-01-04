package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IFactor2;
import ch.fhnw.cpib.parsing.IFactor21;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExpr;

public class Factor2 implements IFactor2 {

	private IToken ident;
	private IFactor21 factor21;

	public Factor2(IToken ident, IFactor21 factor21) {
		this.ident = ident;
		this.factor21 = factor21;
	}

	public IExpr toAbsSyn() {
		return factor21.toAbsSyn(ident);
	}

	@Override
	public String toString(String indent) {
		return indent + "<Factor2>\n" + ident.toString(indent + '\t')
				+ factor21.toString(indent + '\t') + indent + "</Factor2>\n";
	}
}
