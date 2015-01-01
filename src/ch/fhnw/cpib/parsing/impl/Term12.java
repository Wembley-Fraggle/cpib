package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IRelopr;
import ch.fhnw.cpib.parsing.ITerm12;
import ch.fhnw.cpib.parsing.ITerm2;

public class Term12 implements ITerm12 {

    private IRelopr relopr;
    private ITerm2 term2;

    public Term12(IRelopr relopr, ITerm2 term2) {
        this.relopr = relopr;
        this.term2 = term2;
    }

}
