package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IAddopr;
import ch.fhnw.cpib.parsing.as.IAbsMonadicOpr;
import ch.fhnw.cpib.parsing.as.IAbsTerm211;

public class AddoprPlus implements IAddopr {

    IToken plusOpr;
    public AddoprPlus(IToken plusOpr) {
        this.plusOpr = plusOpr;
    }
    
    public IAbsMonadicOpr toAbsSyn(IAbsMonadicOpr opr) {
        return opr;
    }
    
    public IAbsTerm211 toAbsSyn(IAbsTerm211 term) {
        return term;
    }

}
