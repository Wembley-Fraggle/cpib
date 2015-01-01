package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IFactor;
import ch.fhnw.cpib.parsing.IFactor3;

public class FactorAdd implements IFactor {

    private IFactor3 factor3;
    public FactorAdd(IFactor3 factor3) {
        this.factor3 = factor3;
    }

}
