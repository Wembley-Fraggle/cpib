package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.ITerm2;
import ch.fhnw.cpib.parsing.ITerm21;
import ch.fhnw.cpib.parsing.ITerm3;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExpr;

public class Term2 implements ITerm2 {

	private ITerm3 term3;
	private ITerm21 term21;

	public Term2(ITerm3 term3, ITerm21 term21) {
		this.term3 = term3;
		this.term21 = term21;
	}

	@Override
	public IExpr toAbsSyn() {
		return term21.toAbsSyn(term3.toAbsSyn());
	}

	@Override
	public String toString(String indent) {
		return indent + "<Term2>\n" + term3.toString(indent + '\t')
				+ term21.toString(indent + '\t') + indent + "</Term2>\n";
	}

}
