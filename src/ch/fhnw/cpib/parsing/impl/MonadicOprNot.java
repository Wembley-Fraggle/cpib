package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IMonadicOpr;

public class MonadicOprNot implements IMonadicOpr {

	private IToken not;

	public MonadicOprNot(IToken not) {
		this.not = not;
	}

	@Override
	public IToken toAbsSyn() {
		return not;
	}

	@Override
	public String toString(String indent) {
		return indent + "<MONADICOPR>" + not.getValue() + "</MONADICOPR>\n";
	}

}
