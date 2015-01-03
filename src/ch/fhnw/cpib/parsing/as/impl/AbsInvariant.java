package ch.fhnw.cpib.parsing.as.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.as.IAbsInvariant;
import ch.fhnw.cpib.parsing.as.IAbsMother.IAbsExpr;

public class AbsInvariant implements IAbsInvariant{

    private IToken ident;
    private IAbsExpr expr;
    
    public AbsInvariant() {
        // expr = null => true
    }
    
    public AbsInvariant(IToken ident, IAbsExpr expr) {
        this.ident = ident;
        this.expr = expr;
    }

}
