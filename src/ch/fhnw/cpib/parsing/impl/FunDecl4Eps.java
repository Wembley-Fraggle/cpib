package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IFunDecl4;
import ch.fhnw.cpib.parsing.as.IAbsPostcondition;
import ch.fhnw.cpib.parsing.as.impl.AbsPostcondition;

public class FunDecl4Eps implements IFunDecl4 {

	@Override
	public IAbsPostcondition toAbsSyn() {
		// TODO Auto-generated method stub
		return new AbsPostcondition();
	}

	@Override
	public String toString(String indent) {
		return indent + "<Postcondition>TRUE</Postcondition>\n";
	}

}
