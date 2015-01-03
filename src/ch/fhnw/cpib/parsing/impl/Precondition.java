package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IExpr;
import ch.fhnw.cpib.parsing.IPrecondition;
import ch.fhnw.cpib.parsing.as.IAbsMother.IAbsPrecondition;
import ch.fhnw.cpib.parsing.as.impl.AbsPrecondition;


public class Precondition implements IPrecondition{
    private IToken pre;
    private IToken ident;
    private IToken colon;
    private IExpr expr;
    
    public Precondition(IToken pre, IToken ident, IToken colon, IExpr expr) {
        this.pre = pre;
        this.ident = ident;
        this.colon = colon;
        this.expr = expr;
    }
    
    public IAbsPrecondition toAbsSyn(){
    	return new AbsPrecondition(expr.toAbsSyn());
    }
}
