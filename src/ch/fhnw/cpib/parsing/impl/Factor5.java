package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IConcExpr;
import ch.fhnw.cpib.parsing.IFactor5;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExpr;

public class Factor5 implements IFactor5 {

    private IToken lParent;
    private IConcExpr expr;
    private IToken rParent;
    public Factor5(IToken lParent, IConcExpr expr, IToken rParent) {
        this.lParent = lParent;
        this.expr = expr;
        this.rParent = rParent;
    }

}
