package ch.fhnw.cpib.parsing.tools;

import java.nio.channels.IllegalSelectorException;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import org.apache.log4j.Logger;

import ch.fhnw.cpib.parsing.nodes.IEmptyWord;
import ch.fhnw.cpib.parsing.nodes.IGrammar;
import ch.fhnw.cpib.parsing.nodes.INonTerminal;
import ch.fhnw.cpib.parsing.nodes.IProduction;
import ch.fhnw.cpib.parsing.nodes.IProductionNode;
import ch.fhnw.cpib.parsing.nodes.ITerminal;
import ch.fhnw.cpib.parsing.nodes.ProductionNodeUtil;

// TODO Fix confusing logging
public class FirstAnalyser {
    private static final Logger logger = Logger.getLogger(FirstAnalyser.class);

    private IGrammar grammar;

    public FirstAnalyser() {

    }
    
    public FirstAnalyser(IGrammar grammar) {
        this.grammar = grammar;
    }
    
    public IGrammar getGrammar() {
        return this.grammar;
    }
    
    public void setGrammar(IGrammar grammer) {
        this.grammar = grammer;
    }

    public Set<ITerminal> first(List<IProductionNode> chain) {
        Stack<List<IProductionNode>> nodes = new Stack<>();
        
        nodes.push(new LinkedList<>(chain));
        Set<ITerminal> result = first(nodes);
        return result;
    }
    
    
    public Set<ITerminal> first(INonTerminal nonTerminal) {
        Stack<List<IProductionNode>> nodes = new Stack<>();
        
        for(List<IProductionNode> chain : expand(nonTerminal)) {
            nodes.push(chain);
        }
        
        Set<ITerminal> result = first(nodes);
        return result;
    }
    
    public Set<ITerminal> first(Stack<List<IProductionNode>> nodes) {
        if (grammar == null) {
            throw new IllegalStateException("Syntax must be set before");
        }
        if(nodes == null || nodes.size() == 0) {
            throw new IllegalStateException("Nodes not initialized");
        }
        
        NullableCheck nullabelChecker = new NullableCheck(grammar);

        Set<ITerminal> result = new LinkedHashSet<>();
        while (!nodes.isEmpty()) {
            List<IProductionNode> nodeChain = nodes.pop();
            IProductionNode node = null;
            if(nodeChain.size() > 0) {
                node = nodeChain.get(0);
            }
            
            if (node instanceof IEmptyWord) {
                logResolveEmptyWord((IEmptyWord) node);
            } else if (node instanceof ITerminal) {
                result.add((ITerminal) node);
                logResolveTerminal(nodeChain, node);
            } else if (node instanceof INonTerminal) {
                INonTerminal nt = (INonTerminal) node;
                
                for(List<IProductionNode> chain : expand(nt)) {
                    nodes.push(chain);
                }
                

                if (nodeChain.size() == 1 || !nullabelChecker.isNullable(nt)) {
                    logResolveNonTerminal(nodeChain, nt);
                } else {
                    nodeChain.remove(0);
                    nodes.push(nodeChain);
                    logResolveNonTerminal(nodeChain, nt, nodeChain);
                }
            }
        }
        return result;
    }

    private void logResolveTerminal(List<IProductionNode> nodeChain,
            IProductionNode node) {
        if (logger.isDebugEnabled()) {
            StringBuilder builder = new StringBuilder();
            builder.append("FIRST(")
                    .append(ProductionNodeUtil.toString(nodeChain))
                    .append(") -> {").append(node.toString()).append("}");
            logger.debug(builder.toString());
        }
    }

    private void logResolveEmptyWord(IEmptyWord node) {
        if (logger.isDebugEnabled()) {
            StringBuilder builder = new StringBuilder();
            builder.append("FIRST(");
            builder.append(node);
            builder.append(") -> {}");
            logger.debug(builder.toString());
        }
    }

    private void logResolveNonTerminal(List<IProductionNode> nodeChain,
            INonTerminal nt) {
        logResolveNonTerminal(nodeChain, nt, null);
    }

    private void logResolveNonTerminal(List<IProductionNode> nodeChain,
            INonTerminal nt, List<IProductionNode> beta) {
        if (logger.isDebugEnabled()) {

            StringBuilder builder = new StringBuilder();
            builder.append("FIRST(")
                    .append(ProductionNodeUtil.toString(nodeChain))
                    .append(") -> UNION(FIRST(").append(nt.getName())
                    .append(") ").append("FIRST(")
                    .append(ProductionNodeUtil.toString(nodeChain))
                    .append("))");

            logger.debug(builder.toString());
        }
    }

    private List<List<IProductionNode>> expand(INonTerminal nonterminal) {
        StringBuilder builder = new StringBuilder();
        
        List<List<IProductionNode>> result = new LinkedList<>();        
        builder.append("FIRST(").append(nonterminal).append(") -> UNION( ");

        for (IProduction p : grammar.getProductions(nonterminal)) {
            result.add(p.getBody());

            builder.append("FIRST(")
                    .append(ProductionNodeUtil.toString(p.getBody()))
                    .append(") ");
        }

        builder.append(")");
        logger.debug(builder.toString());
        return result;
    }
}
