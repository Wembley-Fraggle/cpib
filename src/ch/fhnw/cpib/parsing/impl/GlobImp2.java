package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IChangemode;
import ch.fhnw.cpib.parsing.IGlobImp2;

public class GlobImp2 implements IGlobImp2 {

	private IChangemode changemode;

	public GlobImp2(IChangemode changemode) {
		this.changemode = changemode;
	}

	@Override
	public String toString(String indent) {
		return indent + "<GlobImp2>\n" + changemode.toString(indent + '\t')
				+ indent + "</GlobImp2>\n";
	}

	@Override
	public IChangemode toAbsSyn() {
		return changemode;
	}
}
