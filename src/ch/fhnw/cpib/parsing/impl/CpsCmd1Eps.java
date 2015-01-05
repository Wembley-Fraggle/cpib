package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.ICpsCmd1;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.ICpsCmd;
import ch.fhnw.cpib.parsing.abs.impl.CpsCmdEps;

public class CpsCmd1Eps implements ICpsCmd1 {
	@Override
	public String toString(String indent) {
		return indent + "<CpsCmd1Eps/>\n";
	}

	@Override
	public ICpsCmd toAbsSyn() {
		return new CpsCmdEps();
	}
}
