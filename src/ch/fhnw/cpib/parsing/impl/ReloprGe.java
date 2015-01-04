package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IRelopr;

public class ReloprGe implements IRelopr {

    private IToken ge;
    public ReloprGe(IToken ge) {
        this.ge = ge;
    }
    
    @Override
    public IToken toAbsSyn() {
       return ge;
    }

}
