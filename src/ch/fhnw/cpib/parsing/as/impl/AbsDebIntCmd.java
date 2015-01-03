package ch.fhnw.cpib.parsing.as.impl;

import ch.fhnw.cpib.parsing.as.IAbsDebIntCmd;
import ch.fhnw.cpib.parsing.as.IAbsMother.IAbsExpr;

public class AbsDebIntCmd implements IAbsDebIntCmd{

    private IAbsExpr expr;
    
    public AbsDebIntCmd(IAbsExpr expr) {
        this.expr = expr;
    }

}
