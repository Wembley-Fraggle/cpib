package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IProcDecl4;

public class ProcDecl4Eps implements IProcDecl4 {

	@Override
	public String toString(String indent) {
		return indent + "<Postcondition>TRUE</Postcondition>\n";
	}

}
