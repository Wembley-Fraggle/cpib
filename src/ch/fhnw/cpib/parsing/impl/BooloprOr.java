package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IBoolopr;
import ch.fhnw.cpib.parsing.as.IAbsExpr2;

public class BooloprOr implements IBoolopr {

    private IToken booloprOr;
    public BooloprOr(IToken booloprOr) {
        this.booloprOr = booloprOr;
    }
    
    public IToken toAbsSyn() {
        return booloprOr;
    }

}
