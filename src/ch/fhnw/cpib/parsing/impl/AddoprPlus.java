package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IAddopr;

public class AddoprPlus implements IAddopr {

    IToken plusOpr;
    public AddoprPlus(IToken plusOpr) {
        this.plusOpr = plusOpr;
    }

}
