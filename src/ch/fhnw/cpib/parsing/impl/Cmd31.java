package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.ICmd31;
import ch.fhnw.cpib.parsing.IInvariant;
import ch.fhnw.cpib.parsing.as.IAbsInvariant;

public class Cmd31 implements ICmd31 {

	private IInvariant invariant;

	public Cmd31(IInvariant invariant) {
		this.invariant = invariant;
	}

	@Override
	public IAbsInvariant toAbsSyn() {
		return invariant.toAbsSyn();
	}

	@Override
	public String toString(String indent) {
		return indent + "<invariant>\n" + invariant.toString(indent + '\t')
				+ indent + "</invariant>\n";
	}

}
