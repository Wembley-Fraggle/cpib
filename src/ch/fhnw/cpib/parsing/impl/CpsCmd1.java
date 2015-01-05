package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.ICpsCmd1;
import ch.fhnw.cpib.parsing.ICpsCmd2;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.ICpsCmd;

public class CpsCmd1 implements ICpsCmd1 {

	private ICpsCmd2 cpsCmd2;
	private ICpsCmd1 cpsCmd1;

	public CpsCmd1(ICpsCmd2 cpsCmd2, ICpsCmd1 cpsCmd1) {
		this.cpsCmd2 = cpsCmd2;
		this.cpsCmd1 = cpsCmd1;
	}

	@Override
	public String toString(String indent) {
		return indent + "<CpsCmd1>\n" + cpsCmd2.toString(indent + '\t')
				+ cpsCmd1.toString(indent + '\t') + indent + "</CpsCmd1>\n";
	}

	@Override
	public ICpsCmd toAbsSyn() {
		return new ch.fhnw.cpib.parsing.abs.impl.CpsCmd(cpsCmd2.toAbsSyn(), cpsCmd1.toAbsSyn());
	}

}
