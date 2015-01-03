package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IFunDecl4;
import ch.fhnw.cpib.parsing.as.IAbsMother.IAbsExpr;
import ch.fhnw.cpib.parsing.as.IAbsMother.IAbsPostcondition;
import ch.fhnw.cpib.parsing.as.impl.AbsPostcondition;

public class FunDecl4Eps implements IFunDecl4 {

	@Override
	public IAbsPostcondition toAbsSyn(IAbsExpr expr) {
		// TODO Auto-generated method stub
		return new AbsPostcondition(expr);
	}

}
