package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IFunDecl4;
import ch.fhnw.cpib.parsing.IPostcondition;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IDbcCmd;

public class FunDecl4 implements IFunDecl4 {

	private IPostcondition postcondition;

	public FunDecl4(IPostcondition postcondition) {
		this.postcondition = postcondition;
	}

	@Override
	public IDbcCmd toAbsSyn() {
		return postcondition.toAbsSyn();
	}

	@Override
	public String toString(String indent) {
		return indent + "<Postcondition>" + postcondition.toString(indent)
				+ "</Postcondition>\n";
	}

}
