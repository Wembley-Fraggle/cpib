package ch.fhnw.cpib.parsing.abs.impl;

import java.util.Set;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IGlobInit;

public final class GlobInit implements IGlobInit {
	private final IToken ident;
	private final IGlobInit globInit;
	
	public GlobInit(final IToken ident, final IGlobInit globInit) {
		this.ident = ident;
		this.globInit = globInit;
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<GlobInit>\n"
				+ ident.toString(indent + '\t')
				+ globInit.toString(indent + '\t')
				+ indent
				+ "</GlobInit>\n";
	}
	
	@Override
	public int getLine() {
	    return ident.getStart().getCurrentLine();
	}

    @Override
    public Set<String> check(final Set<String> initList) throws ContextError {
        if (initList.contains(ident.getValue())) {
            throw new ContextError(
                    "Global init already declared!" 
                        + " Ident: " + ident.getValue(), 
                    ident.getStart().getCurrentLine());
        } else {
            initList.add(ident.getValue());
        }
        return globInit.check(initList);
    }
}
