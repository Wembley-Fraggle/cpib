package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.ITerm11;
import ch.fhnw.cpib.parsing.ITerm12;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExpr;

public class Term11 implements ITerm11 {

    private ITerm12 term12;
    
    public Term11(ITerm12 term12) {
        this.term12 = term12;
    }

    @Override
    public IExpr toAbsSyn(IExpr left) {
        // TODO Auto-generated method stub
        return null;
    }

}
