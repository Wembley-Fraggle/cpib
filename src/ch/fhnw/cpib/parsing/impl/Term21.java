package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.ITerm21;
import ch.fhnw.cpib.parsing.ITerm211;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExpr;

public class Term21 implements ITerm21 {

    private ITerm211 term211;
    private ITerm21 term21;

    public Term21(ITerm211 term211, ITerm21 term21) {
        this.term211 = term211;
        this.term21 = term21;
    }

    @Override
    public IExpr toAbsSyn(IExpr expr) {
        return term21.toAbsSyn(term211.toAbsSyn(expr));
    }
}
