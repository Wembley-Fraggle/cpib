package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.ICpsCmd1;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.ICmd;

public class CpsCmd1Eps implements ICpsCmd1 {
	@Override
	public String toString(String indent) {
		return indent + "<CpsCmd1Eps/>\n";
	}

	@Override
	public ICmd toAbsSyn(ICmd iCmd) {
		return iCmd;
	}
}
