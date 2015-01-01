package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IGlobInits;
import ch.fhnw.cpib.parsing.IIdents;

public class GlobInits implements IGlobInits {

    private IToken init;
    private IIdents idents;
    public GlobInits(IToken init, IIdents idents) {
        this.init = init;
        this.idents = idents;
    }

}
