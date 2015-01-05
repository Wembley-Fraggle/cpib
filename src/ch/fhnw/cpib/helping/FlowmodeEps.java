package ch.fhnw.cpib.helping;

import ch.fhnw.cpib.context.Modes;
import ch.fhnw.cpib.parsing.IFlowmode;
import ch.fhnw.cpib.parsing.abs.IAbstSyn;

public class FlowmodeEps implements IFlowmode, IAbstSyn {

	@Override
	public String toString(String indent) {
		return indent + "<FlowmodeEps/>\n";
	}

	@Override
	public Modes getMode() {
		return Modes.IN;
	}

	@Override
	public int getLine() {
		return -1;
	}

}
