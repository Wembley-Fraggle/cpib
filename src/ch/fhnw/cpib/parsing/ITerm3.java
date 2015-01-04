package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExpr;


public interface ITerm3 extends IConcSynNode {
    IExpr toAbsSyn(); 
}
