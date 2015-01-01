package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IMechmode;

public class MechmodeRef implements IMechmode {

    private IToken mechmodeRef;

    public MechmodeRef(IToken mechmodeRef) {
        this.mechmodeRef = mechmodeRef;
    }
}
