package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IRelopr;

public class ReloprGt implements IRelopr {

    private IToken gt;
    
    public ReloprGt(IToken gt) {
        this.gt = gt;
    }

}
