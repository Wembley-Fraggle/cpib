package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IFactor;
import ch.fhnw.cpib.parsing.IFactor3;
import ch.fhnw.cpib.parsing.IMonadicOpr;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExpr;
import ch.fhnw.cpib.parsing.abs.impl.ExprMonadic;

public class Factor3 implements IFactor3 {

    private IMonadicOpr monadicOpr;
    private IFactor factor;
    
    public Factor3(IMonadicOpr monadicOpr, IFactor factor) {
        this.monadicOpr = monadicOpr;
        this.factor = factor;
    }

    @Override
    public IExpr toAbsSyn() {
        return new ExprMonadic(monadicOpr.toAbsSyn(), factor.toAbsSyn());
    }

}
