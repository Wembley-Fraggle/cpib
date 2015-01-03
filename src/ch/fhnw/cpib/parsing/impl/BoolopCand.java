package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IBoolopr;

public class BoolopCand implements IBoolopr {

    private IToken boolOprCand;

    public BoolopCand(IToken boolOprCand) {
        this.boolOprCand = boolOprCand;
    }
    
    public IToken toAbsSyn() {
        return boolOprCand;
    }
}
