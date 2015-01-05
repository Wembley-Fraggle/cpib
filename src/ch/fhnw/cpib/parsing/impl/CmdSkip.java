package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.ICCmd;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.ICmd;

public class CmdSkip implements ICCmd {

	private IToken skip;

	public CmdSkip(IToken skip) {
		this.skip = skip;
	}

	public ICmd toAbsSyn() {
		return new ch.fhnw.cpib.parsing.abs.impl.CmdSkip();
	}

	@Override
	public String toString(String indent) {
		return indent + "<CmdSkip>\n" + skip.toString(indent + '\t') + indent
				+ "</CmdSkip>\n";
	}

}
