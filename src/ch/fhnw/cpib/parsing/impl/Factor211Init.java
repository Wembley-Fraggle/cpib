package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IFactor211;

public class Factor211Init implements IFactor211 {

    private IToken init;
    public Factor211Init(IToken init) {
        this.init = init;
    }

}
