package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IFactor1;
import ch.fhnw.cpib.parsing.ILiteral;
import ch.fhnw.cpib.parsing.as.IAbsMother.IAbsExpr;
import ch.fhnw.cpib.parsing.as.impl.AbsLiteralExpr;


//TODO Take a IToken
public class Factor1 implements IFactor1{
    ILiteral literal;
    
    public Factor1(ILiteral literal) {
        this.literal = literal;
    }
    
    public IAbsExpr toAbsSyn(){
    	return new AbsLiteralExpr(literal);
    }
}
