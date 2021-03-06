package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IFlowmode;
import ch.fhnw.cpib.parsing.IGlobImp1;

public class GlobImp1 implements IGlobImp1 {

	private IFlowmode flowmode;

	public GlobImp1(IFlowmode flowmode) {
		this.flowmode = flowmode;
	}

	@Override
	public String toString(String indent) {
		return indent + "<GlobImp1>\n" + flowmode.toString(indent + '\t') + indent
				+ "</GlobImp1>\n";
	}

	@Override
	public IFlowmode toAbsSyn() {
		return flowmode;
	}
}
