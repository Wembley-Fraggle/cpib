package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IBoolopr;
import ch.fhnw.cpib.parsing.as.IAbsDyad;
import ch.fhnw.cpib.parsing.as.IAbsExpr2;
import ch.fhnw.cpib.parsing.as.impl.AbsDyad;

public class BoolopCand implements IBoolopr {

    private IToken boolOprCand;

    public BoolopCand(IToken boolOprCand) {
        this.boolOprCand = boolOprCand;
    }
    
    public IAbsExpr2 toAbsSyn(IAbsExpr2 e) {
        return e;
    }
}
