package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IConcExpr;
import ch.fhnw.cpib.parsing.IInvariant;
import ch.fhnw.cpib.parsing.as.IAbsInvariant;
import ch.fhnw.cpib.parsing.as.impl.AbsInvariant;

public class Invariant implements IInvariant {

    private IToken inv;
    private IToken ident;
    private IToken colon;
    private IConcExpr expr;

    public Invariant(IToken inv, IToken ident, IToken colon, IConcExpr expr) {
        this.inv = inv;
        this.ident = ident;
        this.colon = colon;
        this.expr = expr;
    }

    @Override
    public IAbsInvariant toAbsSyn() {
        return new AbsInvariant(ident, expr.toAbsSyn());
    }
}
