package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IBoolVal;

public class BoolValFalse implements IBoolVal{
    private IToken value;
    public BoolValFalse(IToken boolVal) {
        this.value = value;
    }
    
    public IToken toAbsSyn() {
        return value;
    }
}
