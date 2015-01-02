package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IBoolVal;

public class BoolValTrue implements IBoolVal {

    private IToken boolVal;
    public BoolValTrue(IToken boolVal) {
        this.boolVal = boolVal;
    }

}
