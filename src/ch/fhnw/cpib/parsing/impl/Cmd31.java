package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.ICmd31;
import ch.fhnw.cpib.parsing.IInvariant;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IDbcCmd;

public class Cmd31 implements ICmd31 {

	private IInvariant invariant;

	public Cmd31(IInvariant invariant) {
		this.invariant = invariant;
	}

	@Override
	public String toString(String indent) {
		return indent + "<invariant>\n" + invariant.toString(indent + '\t')
				+ indent + "</invariant>\n";
	}

    @Override
    public IDbcCmd toAbsSyn() {
        return invariant.toAbsSyn();
    }

}
