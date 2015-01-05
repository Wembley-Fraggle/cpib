package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IFactor;
import ch.fhnw.cpib.parsing.IFactor1;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExpr;

public class Factor implements IFactor {
	private IFactor1 factor1;

	public Factor(IFactor1 factor1) {
		this.factor1 = factor1;
	}

	@Override
	public IExpr toAbsSyn() {
		return factor1.toAbsSyn();
	}

	@Override
	public String toString(String indent) {
		return indent + "<Factor>\n" + factor1.toString(indent + '\t') + indent
				+ "</Factor>\n";
	}

}
