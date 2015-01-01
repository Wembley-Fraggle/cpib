package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IFunDecl11;
import ch.fhnw.cpib.parsing.IGlobImps;

public class FunDecl11 implements IFunDecl11 {

    private IToken gloabl;
    private IGlobImps globImps;

    public FunDecl11(IToken gloabl, IGlobImps globImps) {
        this.gloabl = gloabl;
        this.globImps = globImps;
    }
}
