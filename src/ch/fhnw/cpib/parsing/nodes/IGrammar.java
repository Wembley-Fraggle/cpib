package ch.fhnw.cpib.parsing.nodes;

import java.util.Set;

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
