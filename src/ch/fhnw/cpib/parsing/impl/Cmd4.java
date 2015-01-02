package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.ICmd4;
import ch.fhnw.cpib.parsing.ICmd41;
import ch.fhnw.cpib.parsing.IExprList;

public class Cmd4 implements ICmd4 {

    private IToken call;
    private IToken ident;
    private IExprList exprList;
    private ICmd41 cmd41;
    
    public Cmd4(IToken call, IToken ident, IExprList exprList, ICmd41 cmd41) {
        this.call = call;
        this.ident = ident;
        this.exprList = exprList;
        this.cmd41 = cmd41;
    }

}
