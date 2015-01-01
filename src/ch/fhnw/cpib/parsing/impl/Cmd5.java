package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.ICmd5;
import ch.fhnw.cpib.parsing.IExpr;


//TODO Take a IToken
public class Cmd5 implements ICmd5{
    private IExpr expr;
    public Cmd5(IExpr expr) {
        this.expr = expr;
    }
    
}
