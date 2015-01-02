package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IExpr;
import ch.fhnw.cpib.parsing.IFactor5;

public class Factor5 implements IFactor5 {

    private IToken lParent;
    private IExpr expr;
    private IToken rParent;
    public Factor5(IToken lParent, IExpr expr, IToken rParent) {
        this.lParent = lParent;
        this.expr = expr;
        this.rParent = rParent;
    }

}
