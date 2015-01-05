package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IProgram2;
import ch.fhnw.cpib.parsing.IProgram21;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.ICpsDecl;

public class Program2 implements IProgram2 {
	private IProgram21 program21;

	public Program2(IProgram21 program21) {
		this.program21 = program21;
	}

	@Override
	public String toString(String indent) {
		return indent + "<Program2>\n" + program21.toString(indent) + indent
				+ "</Program2>\n";
	}

	@Override
	public ICpsDecl toAbsSyn() {
		return program21.toAbsSyn();
	}
}
