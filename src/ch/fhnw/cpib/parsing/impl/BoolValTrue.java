package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IBoolVal;

public class BoolValTrue implements IBoolVal {

    private IToken value;
    public BoolValTrue(IToken value) {
        this.value = value;
    }
    
    public IToken toAbsSyn() {
        return value;
    }
}
