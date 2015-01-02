package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IExpr;
import ch.fhnw.cpib.parsing.IFactor4;

public class Factor4 implements IFactor4 {
    private IToken old;
    private IToken lParent;
    private IExpr expr;
    private IToken rParent;
    
    public Factor4(IToken old, IToken lParent, IExpr expr, IToken rParent) {
        this.old = old;
        this.lParent = lParent;
        this.expr = expr;
        this.rParent = rParent;
    }

}
