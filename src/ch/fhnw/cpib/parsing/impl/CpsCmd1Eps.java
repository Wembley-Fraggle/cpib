package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.ICpsCmd1;
import ch.fhnw.cpib.parsing.as.IAbsCpsCmd;

public class CpsCmd1Eps implements ICpsCmd1 {
	public IAbsCpsCmd toAbsSyn(IAbsCpsCmd e) {
		return e;
	}

	@Override
	public String toString(String indent) {
		return indent + "<CpsCmd1Eps/>\n";
	}
}
