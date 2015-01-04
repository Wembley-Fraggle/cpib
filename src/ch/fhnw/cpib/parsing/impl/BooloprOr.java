package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IBoolopr;

public class BooloprOr implements IBoolopr {

	private IToken booloprOr;

	public BooloprOr(IToken booloprOr) {
		this.booloprOr = booloprOr;
	}

	@Override
	public IToken toAbsSyn() {
		return booloprOr;
	}

	@Override
	public String toString(String indent) {
		return indent + "<BOOLOPR>\n" + booloprOr.toString(indent + '\t') + indent
				+ "</BOOLOPR>\n";
	}
}
