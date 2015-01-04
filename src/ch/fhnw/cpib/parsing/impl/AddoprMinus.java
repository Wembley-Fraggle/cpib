package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IAddopr;

public class AddoprMinus implements IAddopr {

    private IToken minusOpr;
    public AddoprMinus(IToken minusOpr) {
        this.minusOpr = minusOpr;
    }
}
