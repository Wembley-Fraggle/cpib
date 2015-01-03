package ch.fhnw.cpib.parsing.as.impl;

import ch.fhnw.cpib.parsing.as.IAbsAssertCmd;
import ch.fhnw.cpib.parsing.as.IAbsMother.IAbsExpr;

public class AbsAssertCmd implements IAbsAssertCmd {

    private IAbsExpr expr;
    public AbsAssertCmd(IAbsExpr expr) {
        this.expr = expr;
    }

}
