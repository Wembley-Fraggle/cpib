package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.ICCmd;
import ch.fhnw.cpib.parsing.ICpsCmd2;
import ch.fhnw.cpib.parsing.as.IAbsCpsCmd;
import ch.fhnw.cpib.parsing.as.impl.AbsCpsCmd;

public class CpsCmd2 implements ICpsCmd2 {
	private IToken semi;
    private ICCmd cmd;

    public CpsCmd2(IToken semi, ICCmd cmd) {
		this.semi = semi;
		this.cmd = cmd;
	}

	@Override
	public IAbsCpsCmd toAbsSyn() {
		return new AbsCpsCmd(cmd.toAbsSyn());
	}

	@Override
	public String toString(String indent) {
		return indent + "<CpsCmd2>\n" + cmd.toString(indent + '\t') + indent
				+ "</CpsCmd2>\n";
	}

}
