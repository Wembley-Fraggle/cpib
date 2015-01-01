package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IIdents;
import ch.fhnw.cpib.parsing.IIdents1;

public class Idents implements IIdents {

    private IToken ident;
    private IIdents1 idents1;
    
    public Idents(IToken ident, IIdents1 idents1) {
        this.ident = ident;
        this.idents1 = idents1;
    }

}
