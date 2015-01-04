package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.ITerm11;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExpr;
import ch.fhnw.cpib.parsing.as.IAbsExpr;

public class Term11Eps implements ITerm11 {

    @Override
    public IExpr toAbsSyn(IExpr left) {
        return left;
    }

}
