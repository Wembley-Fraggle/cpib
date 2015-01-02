package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IExpr;
import ch.fhnw.cpib.parsing.IInvariant;

public class Invariant implements IInvariant {

    private IToken consume;
    private IToken consume2;
    private IToken consume3;
    private IExpr expr2;

    public Invariant(IToken consume, IToken consume2, IToken consume3,
            IExpr expr2) {
        this.consume = consume;
        this.consume2 = consume2;
        this.consume3 = consume3;
        this.expr2 = expr2;
    }
}
