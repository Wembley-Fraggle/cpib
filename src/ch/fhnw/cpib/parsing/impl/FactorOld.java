package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IFactor;
import ch.fhnw.cpib.parsing.IFactor4;

public class FactorOld implements IFactor {

    private IFactor4 old;
    public FactorOld(IFactor4 old) {
        this.old = old;
    }

}
