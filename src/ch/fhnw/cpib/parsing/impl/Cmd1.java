package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.ICmd1;
import ch.fhnw.cpib.parsing.IExpr;
import ch.fhnw.cpib.parsing.as.IAbsAssiCmd;
import ch.fhnw.cpib.parsing.as.impl.AbsAssiCmd;

public class Cmd1 implements ICmd1 {

    private IExpr leftExpr;
    private IToken becomes;
    private IExpr rightExpr;
    public Cmd1(IExpr leftExpr, IToken becomes, IExpr rightExpr) {
        this.leftExpr = leftExpr;
        this.becomes = becomes;
        this.rightExpr = rightExpr;
    }
    
    public IAbsAssiCmd toAbsSyn() {
        return new AbsAssiCmd(leftExpr.toAbsSyn(), rightExpr.toAbsSyn());
    }
}
