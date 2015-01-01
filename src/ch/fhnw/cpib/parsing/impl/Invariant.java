package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IExpr;
import ch.fhnw.cpib.parsing.IInvariant;

public class Invariant implements IInvariant{
    private String ident;
    private IExpr expr;
    
    public Invariant(String ident,IExpr expr) {
        this.ident = ident;
        this.expr = expr;
    }
}
