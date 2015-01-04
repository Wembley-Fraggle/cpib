package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.ITerm31;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExpr;

public class Term31Eps implements ITerm31 {

    @Override
    public IExpr toAbsSyn(IExpr left) {
       return left;
    }

}
