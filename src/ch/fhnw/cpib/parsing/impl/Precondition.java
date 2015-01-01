package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IExpr;
import ch.fhnw.cpib.parsing.IPrecondition;


//TODO Take a IToken
public class Precondition implements IPrecondition{
    String ident;
    IExpr expr;
    public Precondition(String ident, IExpr expr) {
        this.ident = ident;
        this.expr = expr;
    }
}
