package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.ICmd6;
import ch.fhnw.cpib.parsing.IExpr;


//TODO Take a IToken
public class Cmd6 implements ICmd6{
    IExpr expr;
    
    public Cmd6(IExpr expr) {
        this.expr = expr;
    }
}
