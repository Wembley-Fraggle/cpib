package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IExpr;
import ch.fhnw.cpib.parsing.IIdent;
import ch.fhnw.cpib.parsing.IInvariant;

public class Invariant implements IInvariant{
    private IIdent ident;
    private IExpr expr;
    
    public Invariant(IIdent ident,IExpr expr) {
        this.ident = ident;
        this.expr = expr;
    }
}
