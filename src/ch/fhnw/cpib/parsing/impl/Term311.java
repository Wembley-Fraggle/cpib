package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IFactor;
import ch.fhnw.cpib.parsing.IMultopr;
import ch.fhnw.cpib.parsing.ITerm311;

public class Term311 implements ITerm311 {

    private IMultopr multopr;
    private IFactor factor;

    public Term311(IMultopr multopr, IFactor factor) {
        this.multopr = multopr;
        this.factor = factor;
    }

}
