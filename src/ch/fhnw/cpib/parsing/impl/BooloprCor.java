package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IBoolopr;
import ch.fhnw.cpib.parsing.as.IAbsExpr2;

public class BooloprCor implements IBoolopr {

    private IToken boolOprCor;
    public BooloprCor(IToken boolOprCor) {
       this.boolOprCor = boolOprCor;
    }
    
    public IToken toAbsSyn() {
        return boolOprCor;
    }

}
