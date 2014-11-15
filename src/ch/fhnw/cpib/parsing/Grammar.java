package ch.fhnw.cpib.parsing;

import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.log4j.Logger;

import ch.fhnw.cpib.lexing.ITerminal;
import ch.fhnw.cpib.parsing.nodes.EndMarker;
import ch.fhnw.cpib.parsing.nodes.IEndMarker;
import ch.fhnw.cpib.parsing.nodes.INonTerminal;
import ch.fhnw.cpib.parsing.nodes.IProduction;
import ch.fhnw.cpib.parsing.nodes.IProductionNode;
import ch.fhnw.cpib.parsing.nodes.Production;

// TODO More logging
// TODO Call it a grammar
public final class Grammar implements IGrammar{
    private Set<IProduction> productionList;
    private static final Logger logger = Logger.getLogger(Grammar.class);
    private INonTerminal startSymbol;
    private IEndMarker endMarker;
    
    public Grammar() {
        productionList = new LinkedHashSet<>();
    }

    /* (non-Javadoc)
     * @see ch.fhnw.cpib.parsing.rule.IGrammar#addProduction(ch.fhnw.cpib.parsing.rule.INonTerminal, ch.fhnw.cpib.parsing.rule.IProductionNode)
     */
    @Override
    public IProduction addProduction(INonTerminal head, IProductionNode body, IProductionNode... optionalBody) {
        IProduction production = new Production(head,body, optionalBody);
        productionList.add(production);
        return production;
    }
    
    /* (non-Javadoc)
     * @see ch.fhnw.cpib.parsing.rule.IGrammar#getProductions(ch.fhnw.cpib.parsing.rule.INonTerminal)
     */
    @Override
    public Set<IProduction> getProductions(INonTerminal nonterminal) {
        return getProductions(nonterminal.getName());
    }

    /* (non-Javadoc)
     * @see ch.fhnw.cpib.parsing.rule.IGrammar#getProductions()
     */
    @Override
    public Set<IProduction> getProductions() {
        return new LinkedHashSet<>(productionList);
    }
    
    /* (non-Javadoc)
     * @see ch.fhnw.cpib.parsing.rule.IGrammar#getProductions(java.lang.String)
     */
    @Override
    public Set<IProduction> getProductions(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name must not be null");
        }
        if (name.length() == 0) {
            throw new IllegalArgumentException("rule name must not be empty");
        }

        Set<IProduction> result = new LinkedHashSet<>();
        for (IProduction p : productionList) {
            if (name.equals(p.getHead().getName())) {
                result.add(p);
            }
        }
        return result;
    }

    @Override
    public Set<ITerminal> getTerminals() {
        return getNodesOfType(ITerminal.class);
    }

    @Override
    public Set<INonTerminal> getNonTerminals() {
        return getNodesOfType(INonTerminal.class);
    }
    
    private <T extends IProductionNode> Set<T> getNodesOfType(Class<T> type) {
        Set<T> nodes = new LinkedHashSet<>();
        for(IProduction p : getProductions()) {
            for(IProductionNode n : p.getBody()) {
                if(type.isAssignableFrom(n.getClass())) {
                    nodes.add((T)n);
                }
            }
        }
        return nodes;
    }

    @Override
    public INonTerminal getStartSymbol() {
        return startSymbol;
    }

    @Override
    public void setStartSymbol(INonTerminal symbol) {
        this.startSymbol = symbol;
    }

    @Override
    public boolean isStartSymbol(INonTerminal node) {
        return this.startSymbol.equals(node);
    }

//    @Override
//    public ITransformation addTransformation(IProduction prod,
//            IProductionNode... target) {
//        // TODO Auto-generated method stub
//        return null;
//    }    
}