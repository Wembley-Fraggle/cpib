package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IBoolopr;
import ch.fhnw.cpib.parsing.IExpr2;
import ch.fhnw.cpib.parsing.ITerm1;

public class Expr2 implements IExpr2 {

    private IBoolopr boolopr;
    private ITerm1 term1;
    public Expr2(IBoolopr boolopr, ITerm1 term1) {
        this.boolopr = boolopr;
        this.term1 = term1;
    }

}
