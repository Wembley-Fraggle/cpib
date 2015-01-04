package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.ICpsDecl2;
import ch.fhnw.cpib.parsing.ICDecl;

public class CpsDecl2 implements ICpsDecl2 {

    private IToken semi;
    private ICDecl decl;
    
    public CpsDecl2(IToken semi, ICDecl decl) {
        this.semi = semi;
        this.decl = decl;
    }

}
