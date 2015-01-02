package ch.fhnw.cpib.parsing.as.impl;

import ch.fhnw.cpib.parsing.as.IAbsCondCmd;
import ch.fhnw.cpib.parsing.as.IAbsCpsCmd;
import ch.fhnw.cpib.parsing.as.IAbsExpr;

public class AbsCondCmd implements IAbsCondCmd{
    private IAbsExpr expr;
    private IAbsCpsCmd cmdBlock;
    private IAbsCpsCmd alt;
    public AbsCondCmd(IAbsExpr expr, IAbsCpsCmd cmdBlock, IAbsCpsCmd alt) {
        this.expr = expr;
        this.cmdBlock = cmdBlock;
        this.alt = alt;
    }
}
