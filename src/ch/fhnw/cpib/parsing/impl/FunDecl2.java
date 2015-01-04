package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IFunDecl2;
import ch.fhnw.cpib.parsing.IFunDecl21;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.ICpsDecl;

public class FunDecl2 implements IFunDecl2 {
	private IFunDecl21 funDecl21;

	public FunDecl2(IFunDecl21 funDecl21) {
		this.funDecl21 = funDecl21;
	}

	@Override
	public ICpsDecl toAbsSyn() {
		return funDecl21.toAbsSyn();
	}

	@Override
	public String toString(String indent) {
		return indent + "<FunDecl2>\n" + funDecl21.toString(indent + '\t') + indent
				+ "</FunDecl12>\n";
	}

}
