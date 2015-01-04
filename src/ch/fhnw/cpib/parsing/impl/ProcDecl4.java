package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IPostcondition;
import ch.fhnw.cpib.parsing.IProcDecl4;

public class ProcDecl4 implements IProcDecl4 {

	private IPostcondition postcondition;

	public ProcDecl4(IPostcondition postcondition) {
		this.postcondition = postcondition;
	}

	@Override
	public String toString(String indent) {
		return indent + "<Postcondition>" + postcondition.toString(indent)
				+ "</Postcondition>\n";
	}

}
