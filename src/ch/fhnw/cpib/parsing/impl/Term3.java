package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IFactor;
import ch.fhnw.cpib.parsing.ITerm3;
import ch.fhnw.cpib.parsing.ITerm31;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExpr;

public class Term3 implements ITerm3 {

	private IFactor factor;
	private ITerm31 term31;

	public Term3(IFactor factor, ITerm31 term31) {
		this.factor = factor;
		this.term31 = term31;
	}

	@Override
	public IExpr toAbsSyn() {
		return term31.toAbsSyn(factor.toAbsSyn());
	}

	@Override
	public String toString(String indent) {
		return indent + "<Term3>\n" + factor.toString(indent + '\t')
				+ term31.toString(indent + '\t') + indent + "</Term3>\n";
	}
}
