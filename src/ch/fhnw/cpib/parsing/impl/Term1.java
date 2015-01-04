package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.ITerm1;
import ch.fhnw.cpib.parsing.ITerm11;
import ch.fhnw.cpib.parsing.ITerm2;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExpr;

public class Term1 implements ITerm1 {

    private ITerm2 term2;
    private ITerm11 term11;
    public Term1(ITerm2 term2, ITerm11 term11) {
        this.term2 = term2;
        this.term11 = term11;
    }
    
    
    @Override
    public IExpr toAbsSyn() {
        return term11.toAbsSyn(term2.toAbsSyn());
    }
    

}
