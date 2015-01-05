package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.helping.ChangemodeEps;
import ch.fhnw.cpib.parsing.IChangemode;
import ch.fhnw.cpib.parsing.IParam3;

public class Param3Eps implements IParam3 {

	@Override
	public String toString(String indent) {
		return indent + "<ChangemodeEps/>\n";
	}

	@Override
	public IChangemode toAbsSyn() {
		return new ChangemodeEps();
	}

}
