package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IFactor;
import ch.fhnw.cpib.parsing.IFactor2;

public class FactorIdent implements IFactor {

    private IFactor2 factor2;
    public FactorIdent(IFactor2 factor2) {
        this.factor2 = factor2;
    }

}
