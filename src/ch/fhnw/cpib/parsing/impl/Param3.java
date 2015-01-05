package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IChangemode;
import ch.fhnw.cpib.parsing.IParam3;

public class Param3 implements IParam3 {

	private IChangemode changemode;

	public Param3(IChangemode changemode) {
		this.changemode = changemode;
	}

	@Override
	public String toString(String indent) {
		return indent + "<Changemode>\n" + changemode.toString(indent + '\t') + indent
				+ "</Changemode>\n";
	}

	@Override
	public IChangemode toAbsSyn() {
		return changemode;
	}

}
