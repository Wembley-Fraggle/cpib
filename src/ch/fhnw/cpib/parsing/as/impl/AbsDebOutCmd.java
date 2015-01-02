package ch.fhnw.cpib.parsing.as.impl;

import ch.fhnw.cpib.parsing.as.IAbsDebOutCmd;
import ch.fhnw.cpib.parsing.as.IAbsExpr;

public class AbsDebOutCmd implements IAbsDebOutCmd {

    private IAbsExpr expr;

    public AbsDebOutCmd(IAbsExpr expr) {
        this.expr = expr;
    }

}
