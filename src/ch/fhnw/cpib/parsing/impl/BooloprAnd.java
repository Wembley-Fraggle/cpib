package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IBoolopr;
import ch.fhnw.cpib.parsing.as.IAbsExpr2;

public class BooloprAnd implements IBoolopr {

    private IToken boolAnd;

    public BooloprAnd(IToken boolAnd) {
        this.boolAnd = boolAnd;
    }
    
    public IAbsExpr2 toAbsSyn(IAbsExpr2 e) {
        return e;
    }
}
