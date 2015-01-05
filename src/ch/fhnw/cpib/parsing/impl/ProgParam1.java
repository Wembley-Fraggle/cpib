package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IFlowmode;
import ch.fhnw.cpib.parsing.IProgParam1;

public class ProgParam1 implements IProgParam1 {

	private IFlowmode flowmode;

	public ProgParam1(IFlowmode flowmode) {
		this.flowmode = flowmode;
	}

	@Override
	public String toString(String indent) {
		return indent + "<Flowmode>\n" + flowmode.toString(indent + '\t') + indent
				+ "</Flowmode>\n";
	}

	@Override
	public IFlowmode toAbsSyn() {
		return flowmode;
	}

}
