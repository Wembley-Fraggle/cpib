package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.helping.ChangemodeEps;
import ch.fhnw.cpib.parsing.IChangemode;
import ch.fhnw.cpib.parsing.IProgParam2;

public class ProgParam2Eps implements IProgParam2 {

	@Override
	public String toString(String indent) {
		return indent + "<ChangemodeEps/>\n";
	}

	@Override
	public IChangemode toAbsSyn() {
		return new ChangemodeEps();
	}

}
