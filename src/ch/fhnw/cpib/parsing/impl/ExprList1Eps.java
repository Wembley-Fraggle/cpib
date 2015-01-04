package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IExprList1;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExprList;
import ch.fhnw.cpib.parsing.abs.impl.ExprListEps;
import ch.fhnw.cpib.parsing.as.impl.AbsExprList;

public class ExprList1Eps implements IExprList1 {

    @Override
    public IExprList toAbsSyn() {
        return new ExprListEps();
    }
}
