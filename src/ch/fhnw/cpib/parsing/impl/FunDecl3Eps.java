package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IFunDecl3;
import ch.fhnw.cpib.parsing.as.IAbsPrecondition;
import ch.fhnw.cpib.parsing.as.impl.AbsPrecondition;

public class FunDecl3Eps implements IFunDecl3 {

	@Override
	public IAbsPrecondition toAbsSyn() {
		// TODO Auto-generated method stub
		return new AbsPrecondition();
	}

	@Override
	public String toString(String indent) {
		return indent + "<Precondition>TRUE</Precondition>\n";
	}

}
