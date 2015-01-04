package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IFunDecl1;
import ch.fhnw.cpib.parsing.IFunDecl11;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IGlobImp;

public class FunDecl1 implements IFunDecl1 {
	private IFunDecl11 funDecl11;

	public FunDecl1(IFunDecl11 funDecl11) {
		this.funDecl11 = funDecl11;
	}

	@Override
	public IGlobImp toAbsSyn() {
		return funDecl11.toAbsSyn();
	}

	@Override
	public String toString(String indent) {
		return indent + "<FunDecl1>\n" + funDecl11.toString(indent + '\t') + indent
				+ "</FunDecl1>\n";
	}

}
