package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IProcDecl3;

public class ProcDecl3Eps implements IProcDecl3 {

	@Override
	public String toString(String indent) {
		return indent + "<Precondition>TRUE</Precondition>\n";
	}

}
