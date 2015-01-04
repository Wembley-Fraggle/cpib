package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IExprList3;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExpr;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExprList;
import ch.fhnw.cpib.parsing.abs.impl.ExprList;
import ch.fhnw.cpib.parsing.abs.impl.ExprListEps;

public class ExprList3Eps implements IExprList3 {

    @Override
    public IExprList toAbsSyn() {
        return new ExprListEps();
    }
    
}
