package ch.fhnw.cpib.parsing.tools;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import org.apache.log4j.Logger;

import ch.fhnw.cpib.parsing.IGrammar;
import ch.fhnw.cpib.parsing.nodes.IEmptyWord;
import ch.fhnw.cpib.parsing.nodes.INonTerminal;
import ch.fhnw.cpib.parsing.nodes.IProduction;
import ch.fhnw.cpib.parsing.nodes.IProductionNode;
import ch.fhnw.cpib.parsing.nodes.ITerminal;

// TODO More logging
public class NullableCheck {
    private static final Logger logger = Logger.getLogger(NullableCheck.class);

    private IGrammar grammar;

    public NullableCheck() {
    }

    public NullableCheck(IGrammar grammar) {
        this.grammar = grammar;
    }

    public IGrammar getGrammar() {
        return this.grammar;
    }

    public void setGrammar(IGrammar grammar) {
        this.grammar = grammar;
    }

    public boolean isNullable(List<IProductionNode> chain) {
        if (grammar == null) {
            throw new IllegalStateException("Grammar must not be null");
        }

        Stack<List<IProductionNode>> nodes = new Stack<>();
        nodes.push(new LinkedList<>(chain));
        boolean result = isNullable(nodes);

        return result;

    }

    private boolean isNullable(Stack<List<IProductionNode>> nodes) {
        if (nodes == null || nodes.size() == 0) {
            throw new IllegalStateException("Nodes have not been prepared");
        }

        while (!nodes.isEmpty()) {
            List<IProductionNode> nodeChain = nodes.peek();
            
            IProductionNode first = null;
            if(nodeChain.size() > 0) {
                first = nodeChain.get(0);
            }
            if (first instanceof IEmptyWord) {
                return true;
            } else if (first instanceof ITerminal) {
                nodeChain.clear();
            } else if (first instanceof INonTerminal) {
                List<IProductionNode> chain = nodes.pop();
                for (List<IProductionNode> expanded : expand(chain)) {
                    nodes.push(expanded);
                }
            }

            if (nodeChain.size() == 0) {
                nodes.pop();
            }
        }

        return false;
    }

    public boolean isNullable(INonTerminal node) {

        Stack<List<IProductionNode>> nodes = new Stack<>();
        List<IProductionNode> chain = new LinkedList<>();
        chain.add(node);
        nodes.add(chain);
        boolean result = isNullable(nodes);
        nodes = null;
        return result;

    }

    private List<List<IProductionNode>> expand(List<IProductionNode> chain) {
        if (grammar == null) {
            throw new IllegalStateException("Grammar must not be null");
        }

        List<List<IProductionNode>> result = new LinkedList<>();
        IProductionNode first = chain.get(0);
        if (first instanceof INonTerminal) {
            INonTerminal nonTerminal = (INonTerminal) first;
            for (IProduction p : grammar.getProductions(nonTerminal)) {
                List<IProductionNode> chainClone = new LinkedList<IProductionNode>(
                        chain);
                chainClone.remove(0);
                chainClone.addAll(0, p.getBody());
                result.add(chainClone);
            }
        }
        else {
            logger.warn("Can not expand node:"+first.getName());
            result.add(new LinkedList<>(chain));
        }
        return result;
    }

}
