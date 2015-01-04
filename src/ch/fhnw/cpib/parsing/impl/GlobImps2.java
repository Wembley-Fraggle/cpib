package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IGlobImp;
import ch.fhnw.cpib.parsing.IGlobImps2;

public class GlobImps2 implements IGlobImps2 {
	
	private IToken comma;
	private IGlobImp globImp;

	public GlobImps2(IToken comma, IGlobImp globImp) {
		this.comma = comma;
		this.globImp = globImp;
	}
	
	@Override
	public String toString(String indent) {
		return indent + comma.getValue() + globImp.toString(indent) + "\n";
	}

}
