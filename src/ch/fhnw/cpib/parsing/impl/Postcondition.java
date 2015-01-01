package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IExpr;
import ch.fhnw.cpib.parsing.IPostcondition;


//TODO Take a IToken
public class Postcondition implements IPostcondition{
    String ident;
    IExpr expr;
    public Postcondition(String ident, IExpr expr) {
        this.ident = ident;
        this.expr = expr;
    }
}
