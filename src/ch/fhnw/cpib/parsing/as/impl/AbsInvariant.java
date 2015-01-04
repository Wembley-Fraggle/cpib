package ch.fhnw.cpib.parsing.as.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IConcExpr;
import ch.fhnw.cpib.parsing.as.IAbsExpr;
import ch.fhnw.cpib.parsing.as.IAbsInvariant;

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
