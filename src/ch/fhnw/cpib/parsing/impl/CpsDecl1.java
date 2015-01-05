package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.ICpsDecl1;
import ch.fhnw.cpib.parsing.ICpsDecl2;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.ICpsDecl;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IDecl;

public class CpsDecl1 implements ICpsDecl1 {

	private ICpsDecl2 cpsDecl2;
	private ICpsDecl1 cpsDecl1;

	public CpsDecl1(ICpsDecl2 cpsDecl2, ICpsDecl1 cpsDecl1) {
		this.cpsDecl2 = cpsDecl2;
		this.cpsDecl1 = cpsDecl1;
	}

	@Override
	public String toString(String indent) {
		return indent + "<CpsDecl1>\n" + cpsDecl2.toString(indent + '\t')
				+ cpsDecl1.toString(indent + '\t') + indent + "</CpsDecl1>\n";
	}

	@Override
	public ICpsDecl toAbsSyn(IDecl iDecl) {
		return cpsDecl2.toAbsSyn(cpsDecl1.toAbsSyn(iDecl));
//		return new CpsDecl(cpsDecl2.toAbsSyn(), cpsDecl1.toAbsSyn());
	}

}
