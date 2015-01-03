package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IExprList1;
import ch.fhnw.cpib.parsing.as.IAbsMother.IAbsExprList;
import ch.fhnw.cpib.parsing.as.impl.AbsExprList;

public class ExprList1Eps implements IExprList1 {

    @Override
    public IAbsExprList toAbsSyn() {
        return new AbsExprList();
    }
}
