package ch.fhnw.cpib.parsing.as.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.as.IAbsMother.IAbsMotherCopy;

public class AbsMotherCopy implements IAbsMotherCopy {
	
	private IToken ident;
	private IAbsParam params;
	private IAbsInvariant invariant;

	public AbsMotherCopy(IToken ident, IAbsParam params, IAbsInvariant invariant) {
		System.out.println("AbsMotherCopy");
		System.out.println("ident " + ident);
		System.out.println("params " + params);
		System.out.println("invariant" + invariant);
		this.ident = ident;
		this.params = params;
		this.invariant = invariant;
	}
	
	@Override
	public String toString(String indent) {
		return "***AbsMotherCopy***";
	}

	@Override
	public IToken getIdent() {
		return ident;
	}

	@Override
	public IAbsParam getParams() {
		return params;
	}

	@Override
	public IAbsInvariant getInvariant() {
		return invariant;
	}

}
