package ch.fhnw.cpib.parsing.as.impl;

import ch.fhnw.cpib.parsing.as.IAbsExpr;
import ch.fhnw.cpib.parsing.as.IAbsExprList;

public class AbsExprList implements IAbsExprList{
    private IAbsExprList left;
    private IAbsExpr right;
    
    public AbsExprList() {
        // NullObject
    }
    
    public AbsExprList(IAbsExpr right) {
        // Leaf
        this.right = right;
    }
   
    
    public AbsExprList(IAbsExprList left, IAbsExpr right) {
        this.left = left;
        this.right = right;
    }
}
