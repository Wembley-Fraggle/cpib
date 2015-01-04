package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.ICpsStoDecl;
import ch.fhnw.cpib.parsing.ICpsStoDecl1;
import ch.fhnw.cpib.parsing.IFunDecl2;
import ch.fhnw.cpib.parsing.IStoDecl;

public class CpsStoDecl implements ICpsStoDecl {

	private IStoDecl stoDecl;
	private ICpsStoDecl1 cpsStoDecl1;

	public CpsStoDecl(IStoDecl stoDecl, ICpsStoDecl1 cpsStoDecl1) {
		this.stoDecl = stoDecl;
		this.cpsStoDecl1 = cpsStoDecl1;
	}

	@Override
	public IFunDecl2 toAbsSyn() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString(String indent) {
		return indent + "<CpsStoDecl>\n" + stoDecl.toString(indent + '\t')
				+ cpsStoDecl1.toString(indent + '\t') + indent + "</CpsStoDecl>\n";
	}

}
