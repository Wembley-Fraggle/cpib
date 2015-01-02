package ch.fhnw.cpib.parsing.as.impl;

import ch.fhnw.cpib.parsing.as.IAbsAssiCmd;
import ch.fhnw.cpib.parsing.as.IAbsExpr;

public class AbsAssiCmd implements IAbsAssiCmd{
    private IAbsExpr left;
    private IAbsExpr right;
    
    public AbsAssiCmd(IAbsExpr left, IAbsExpr right) {
        this.left = left;
        this.right = right;
    }
}
