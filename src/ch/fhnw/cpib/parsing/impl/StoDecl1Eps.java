package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.helping.ChangemodeEps;
import ch.fhnw.cpib.parsing.IChangemode;
import ch.fhnw.cpib.parsing.IStoDecl1;

public class StoDecl1Eps implements IStoDecl1{

	@Override
	public String toString(String indent) {
		return indent + "<StoDecl1Eps/>\n";
	}

	@Override
	public IChangemode toAbsSyn() {
		return new ChangemodeEps();
	}

}
