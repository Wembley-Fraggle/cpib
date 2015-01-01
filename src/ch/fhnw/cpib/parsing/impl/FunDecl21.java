package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.ICpsStoDecl;
import ch.fhnw.cpib.parsing.IFunDecl21;

public class FunDecl21 implements IFunDecl21 {
    IToken local;
    ICpsStoDecl cpsStoDecl;

    public FunDecl21(IToken local, ICpsStoDecl cpsStoDecl) {
        this.local = local;
        this.cpsStoDecl = cpsStoDecl;
    }

}
