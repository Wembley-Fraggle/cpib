package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IAddopr;
import ch.fhnw.cpib.parsing.ITerm211;
import ch.fhnw.cpib.parsing.ITerm3;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExpr;
import ch.fhnw.cpib.parsing.abs.impl.ExprDyadic;

public class Term211 implements ITerm211 {

    private IAddopr addopr;
    private ITerm3 term3;
    
    public Term211(IAddopr addopr, ITerm3 term3) {
        this.addopr = addopr;
        this.term3 = term3;
    }

    @Override
    public IExpr toAbsSyn(IExpr expr) {
        return new ExprDyadic(addopr.toAbsSyn(),expr,term3.toAbsSyn());
    }

}
