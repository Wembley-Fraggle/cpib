package ch.fhnw.cpib.parsing.abs.impl;

import java.util.Set;

import ch.fhnw.cpib.parsing.abs.IAbstSyn.IGlobInit;

public final class GlobInitEps implements IGlobInit {
	@Override
	public String toString(final String indent) {
		return indent + "<GlobInitEps/>\n";
	}
	
	@Override
	public int getLine() {
	    return -1;
	}

    @Override
    public Set<String> check(final Set<String> initList) throws ContextError {
        return initList;
    }
}
