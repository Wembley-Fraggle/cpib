package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.ICCmd;
import ch.fhnw.cpib.parsing.ICpsCmd;
import ch.fhnw.cpib.parsing.ICpsCmd1;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.ICmd;

public class CpsCmd implements ICpsCmd {
	private ICCmd cmd;
	private ICpsCmd1 cpsCmd1;

	public CpsCmd(ICCmd cmd, ICpsCmd1 cpsCmd1) {
		this.cmd = cmd;
		this.cpsCmd1 = cpsCmd1;
	}

	@Override
	public ICmd toAbsSyn() {
		return new ch.fhnw.cpib.parsing.abs.impl.CpsCmd(cmd.toAbsSyn(), cpsCmd1.toAbsSyn());
	}

	@Override
	public String toString(String indent) {
		return indent + "<Cmd>\n" + cmd.toString(indent + '\t')
				+ cpsCmd1.toString(indent + '\t') + indent + "</Cmd>\n";
	}
}
