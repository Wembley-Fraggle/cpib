package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.helping.FlowmodeEps;
import ch.fhnw.cpib.parsing.IFlowmode;
import ch.fhnw.cpib.parsing.IProgParam1;

public class ProgParam1Eps implements IProgParam1 {

	@Override
	public String toString(String indent) {
		return indent + "<FlowmodeEps/>\n";
	}

	@Override
	public IFlowmode toAbsSyn() {
		return new FlowmodeEps();
	}

}
