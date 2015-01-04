package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.helping.FlowmodeEps;
import ch.fhnw.cpib.parsing.IFlowmode;
import ch.fhnw.cpib.parsing.IGlobImp1;

public class GlobImp1Eps implements IGlobImp1 {

	@Override
	public String toString(String indent) {
		return indent + "<FlowmodeEps/>\n";
	}

	@Override
	public IFlowmode toAbsSyn() {
		return new FlowmodeEps();
	}

}
