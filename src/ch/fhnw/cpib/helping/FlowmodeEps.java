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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLine() {
		return -1;
	}

}
