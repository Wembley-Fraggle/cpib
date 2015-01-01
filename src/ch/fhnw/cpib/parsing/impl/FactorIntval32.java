package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IFactor;
import ch.fhnw.cpib.parsing.IFactor1;

public class FactorIntval32 implements IFactor {

    private IFactor1 factor1;
    public FactorIntval32(IFactor1 factor1) {
        this.factor1 = factor1;
    }

}
