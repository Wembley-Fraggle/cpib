package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IConcExpr;
import ch.fhnw.cpib.parsing.IExpr1;
import ch.fhnw.cpib.parsing.ITerm1;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExpr;

public class Expr implements IConcExpr {

    private ITerm1 term1;
    private IExpr1 expr1;
    
    public Expr(ITerm1 term1, IExpr1 expr1) {
        this.term1 = term1;
        this.expr1 = expr1;
    }

    @Override
    public IExpr toAbsSyn() {
        return expr1.toAbsSyn(term1.toAbsSyn());
    }

}
