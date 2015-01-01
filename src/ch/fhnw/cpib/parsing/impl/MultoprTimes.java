package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IMultopr;

public class MultoprTimes implements IMultopr {

    private IToken times;
    public MultoprTimes(IToken times) {
        this.times = times;
    }

}
