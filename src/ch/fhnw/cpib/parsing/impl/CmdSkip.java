package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.ICCmd;
import ch.fhnw.cpib.parsing.as.IAbsCmd;
import ch.fhnw.cpib.parsing.as.impl.AbsSkipCmd;

public class CmdSkip implements ICCmd {

	private IToken skip;

	public CmdSkip(IToken skip) {
		this.skip = skip;
	}

	public IAbsCmd toAbsSyn() {
		return new AbsSkipCmd();
	}

	@Override
	public String toString(String indent) {
		return indent + "<CmdSkip>\n" + skip.toString(indent + '\t') + indent
				+ "</CmdSkip>\n";
	}

}
