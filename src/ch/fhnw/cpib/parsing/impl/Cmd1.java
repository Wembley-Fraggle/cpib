package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.ICmd1;
import ch.fhnw.cpib.parsing.IConcExpr;
import ch.fhnw.cpib.parsing.as.IAbsCmd;

public class Cmd1 implements ICmd1 {

    private IConcExpr leftExpr;
    private IToken becomes;
    private IConcExpr rightExpr;
    public Cmd1(IConcExpr leftExpr, IToken becomes, IConcExpr rightExpr) {
        this.leftExpr = leftExpr;
        this.becomes = becomes;
        this.rightExpr = rightExpr;
    }
		@Override
		public IAbsCmd toAbsSyn() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public String toString(String indent) {
			// TODO Auto-generated method stub
			return null;
		}
    
//    public IAbsAssiCmd toAbsSyn() {
//        return new AbsAssiCmd(leftExpr.toAbsSyn(), rightExpr.toAbsSyn());
//    }
}
