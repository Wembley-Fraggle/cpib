package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.ICpsStoDecl1;
import ch.fhnw.cpib.parsing.ICpsStoDecl2;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.ICpsDecl;
import ch.fhnw.cpib.parsing.abs.impl.CpsDecl;

public class CpsStoDecl1 implements ICpsStoDecl1 {

	private ICpsStoDecl2 cpsStoDecl2;
	private ICpsStoDecl1 cpsStoDecl1;

	public CpsStoDecl1(ICpsStoDecl2 cpsStoDecl2, ICpsStoDecl1 cpsStoDecl1) {
		this.cpsStoDecl2 = cpsStoDecl2;
		this.cpsStoDecl1 = cpsStoDecl1;
	}

	@Override
	public String toString(String indent) {
		return indent + "<CpsStoDecl1>\n" + cpsStoDecl2.toString(indent + '\t')
				+ cpsStoDecl1.toString(indent + '\t') + indent + "</CpsStoDecl1>\n";
	}

	@Override
	public ICpsDecl toAbsSyn() {
	    return new CpsDecl(cpsStoDecl2.toAbsSyn(), cpsStoDecl1.toAbsSyn());
	}

}
