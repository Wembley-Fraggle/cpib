package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IRelopr;

public class ReloprLe implements IRelopr {

    private IToken le;
    
    public ReloprLe(IToken le) {
        this.le = le;
    }

    @Override
    public IToken toAbsSyn() {
       return le;
    }

}
