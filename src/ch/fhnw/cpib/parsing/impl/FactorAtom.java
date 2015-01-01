package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IFactor;
import ch.fhnw.cpib.parsing.IFactor5;

public class FactorAtom implements IFactor {

    private IFactor5 factor5;
    public FactorAtom(IFactor5 factor5) {
        this.factor5 = factor5;
    }

}
