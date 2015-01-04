package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IProgram1;

public class Program1Eps implements IProgram1{

	@Override
	public String toString(String indent) {
		return indent + "<invariant>TRUE</invariant>\n";
	}
}
