package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IBoolopr;

public class BooloprAnd implements IBoolopr {

    private IToken boolAnd;

    public BooloprAnd(IToken boolAnd) {
        this.boolAnd = boolAnd;
    }

    @Override
    public IToken toAbsSyn() {
       return boolAnd;
    }
}
