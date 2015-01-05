package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.helping.MechmodeEps;
import ch.fhnw.cpib.parsing.IMechmode;
import ch.fhnw.cpib.parsing.IParam2;

public class Param2Eps implements IParam2 {

	@Override
	public String toString(String indent) {
		return indent + "<MechmodeEps/>\n";
	}

	@Override
	public IMechmode toAbsSyn() {
		return new MechmodeEps();
	}

}
