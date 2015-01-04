package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.ITerm2;
import ch.fhnw.cpib.parsing.ITerm21;
import ch.fhnw.cpib.parsing.ITerm3;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExpr;

public class Term2 implements ITerm2 {

    private ITerm3 term3;
    private ITerm21 term21;
    
    public Term2(ITerm3 term3, ITerm21 term21) {
        this.term3 = term3;
        this.term21 = term21;
    }

    @Override
    public IExpr toAbsSyn() {
        // TODO Auto-generated method stub
        return null;
    }

}
