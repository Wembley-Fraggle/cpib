package ch.fhnw.cpib.parsing.as.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.as.IAbsMother.IAbsExpr;

public class AbsExpr implements IAbsExpr{
    
    private IToken term;
    private IAbsExpr left;
    private IAbsExpr right;
    public AbsExpr(IToken term, IAbsExpr left, IAbsExpr right) {
        this.term = term;
        this.left = left;
        this.right = right;
    }
		@Override
		public String toString(String ident) {
			// TODO Auto-generated method stub
			return null;
		}
}
