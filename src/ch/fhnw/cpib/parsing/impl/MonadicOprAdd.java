package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IAddopr;
import ch.fhnw.cpib.parsing.IMonadicOpr;

public class MonadicOprAdd implements IMonadicOpr {

    private IAddopr addopr;
    
    public MonadicOprAdd(IAddopr addopr) {
        this.addopr = addopr;
    }

}