package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IRelopr;

public class ReloprLt implements IRelopr {

    private IToken lt;

    public ReloprLt(IToken lt) {
        this.lt = lt;
    }

}
