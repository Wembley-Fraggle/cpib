package ch.fhnw.cpib.parsing.abs.impl;

import ch.fhnw.cpib.context.Routine;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IGlobImp;

public final class GlobImpEps implements IGlobImp {
	@Override
	public String toString(final String indent) {
		return indent + "<GlobImpEps/>\n";
	}
	
	@Override
	public int getLine() {
	    return -1;
	}

    @Override
    public void check(final Routine routine) throws ContextError { }

    @Override
    public void checkInit() throws ContextError { }
}
