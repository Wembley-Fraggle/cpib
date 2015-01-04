package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IConcExpr;
import ch.fhnw.cpib.parsing.IPostcondition;
import ch.fhnw.cpib.parsing.as.IAbsPostcondition;
import ch.fhnw.cpib.parsing.as.impl.AbsPostcondition;


public class Postcondition implements IPostcondition{
    private IToken consume;
    private IToken consume2;
    private IToken consume3;
    private IConcExpr expr2;
    
    public Postcondition(IToken consume, IToken consume2, IToken consume3,
            IConcExpr expr2) {
        this.consume = consume;
        this.consume2 = consume2;
        this.consume3 = consume3;
        this.expr2 = expr2;
    }
    
    public IAbsPostcondition toAbsSyn(){
    	return new AbsPostcondition(expr2.toAbsSyn());
    }
}
