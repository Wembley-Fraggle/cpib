package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.ICCpsDecl;
import ch.fhnw.cpib.parsing.IProgram21;

public class Program21 implements IProgram21 {
	private IToken global;
	private ICCpsDecl cpsDecl;

	public Program21(IToken global, ICCpsDecl cpsDecl) {
		this.global = global;
		this.cpsDecl = cpsDecl;
	}

	@Override
	public String toString(String indent) {
		// TODO Auto-generated method stub
		return indent + "<" + global.getValue() + ">" + cpsDecl.toString(indent)
				+ "</" + global.getValue() + ">\n";
	}

}
