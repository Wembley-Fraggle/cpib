package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IExpr;
import ch.fhnw.cpib.parsing.IExpr1;
import ch.fhnw.cpib.parsing.ITerm1;
import ch.fhnw.cpib.parsing.as.IAbsExpr;

public class Expr implements IExpr {

    private ITerm1 term1;
    private IExpr1 expr1;
    
    public Expr(ITerm1 term1, IExpr1 expr1) {
        this.term1 = term1;
        this.expr1 = expr1;
    }

    @Override
    public IAbsExpr toAbsSyn() {
        // TODO Auto-generated method stub
        return null;
    }

}
