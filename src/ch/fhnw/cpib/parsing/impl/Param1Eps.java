package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.helping.FlowmodeEps;
import ch.fhnw.cpib.parsing.IFlowmode;
import ch.fhnw.cpib.parsing.IParam1;

public class Param1Eps implements IParam1 {

	@Override
	public String toString(String indent) {
		return indent + "<FlowmodeEps/>\n";
	}

	@Override
	public IFlowmode toAbsSyn() {
		return new FlowmodeEps();
	}

}
