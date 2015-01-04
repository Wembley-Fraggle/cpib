package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IFactor;
import ch.fhnw.cpib.parsing.ITerm3;
import ch.fhnw.cpib.parsing.ITerm31;
import ch.fhnw.cpib.parsing.as.IAbsExpr;

public class Term3 implements ITerm3 {

    private IFactor factor;
    private ITerm31 term31;

    public Term3(IFactor factor, ITerm31 term31) {
        this.factor = factor;
        this.term31 = term31;
    }

    @Override
    public IAbsExpr toAbsSyn() {
        // TODO Auto-generated method stub
        return null;
    }
}
