package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IIdents2;

public class Idents2 implements IIdents2 {
    private IToken comma;
    private IToken ident;
    
    public Idents2(IToken comma, IToken ident) {
        this.comma = comma;
        this.ident = ident;
    }

}
