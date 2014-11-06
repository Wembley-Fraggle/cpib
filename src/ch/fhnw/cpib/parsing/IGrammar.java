package ch.fhnw.cpib.parsing;

import java.util.Set;

import ch.fhnw.cpib.lexing.ITerminal;
import ch.fhnw.cpib.parsing.nodes.INonTerminal;
import ch.fhnw.cpib.parsing.nodes.IProduction;
import ch.fhnw.cpib.parsing.nodes.IProductionNode;

public interface IGrammar {
    
    Set<ITerminal> getTerminals();
    Set<INonTerminal> getNonTerminals();
    INonTerminal getStartSymbol();
    
    void setStartSymbol(INonTerminal symbol);
    
    boolean isStartSymbol(INonTerminal node);
    
    IProduction addProduction(INonTerminal head,IProductionNode body,
            IProductionNode... optionalBody);

    Set<IProduction> getProductions(INonTerminal nonterminal);

    Set<IProduction> getProductions();

    Set<IProduction> getProductions(String name);    
}
