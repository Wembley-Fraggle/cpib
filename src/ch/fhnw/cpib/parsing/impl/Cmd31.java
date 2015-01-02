package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.ICmd31;
import ch.fhnw.cpib.parsing.IInvariant;

public class Cmd31 implements ICmd31 {

    private IInvariant invariant;
    public Cmd31(IInvariant invariant) {
        this.invariant = invariant;
    }

}
