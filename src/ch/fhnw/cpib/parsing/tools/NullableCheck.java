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

    /*
     * As a Precondition this method expects, that the internal stack has
     * already been initialized with a production body. This is a chain of
     * Terminals or nonterminals.
     * 
     * In order to decide whether the chain is nullable or not. The aim is to
     * find a way to derivy the rule to nullable.
     * 
     * Therefore we analyse the first node of the chain. If it is a empty word,
     * the rule can be derivied to the empty word. Therefore the production must
     * be nullable. If the first element of the production body is a terminal,
     * the whole rule is not nullable. In that case, we can remove it from the
     * internal stack. (Note that all possible pathes must not be nullable in
     * order to be able to make a statement about nullability.
     * 
     * The third possibility is, that the first node is a NonTerminal. In That
     * case we expand this node taking the productions with an equal head. Note
     * that this may result in multiple chains.
     */
    private boolean isNullable(Stack<List<IProductionNode>> nodes) {
        if (nodes == null || nodes.size() == 0) {
            // As a precondition in this method, the stack has already
            // be initialized with the first production body.
            throw new IllegalStateException("Nodes have not been prepared");
        }

        // Repeat this until we can make a decision or the stack is empty
        while (!nodes.isEmpty()) {
            List<IProductionNode> nodeChain = nodes.peek();
            IProductionNode first = null;
            if (nodeChain.size() > 0) {
                first = nodeChain.get(0);
                if (first instanceof IEmptyWord) {
                    logger.debug(ProductionNodeUtil.toString(nodeChain)
                            + " => "
                            + true);
                    return true;
                } else if (first instanceof ITerminal) {
                    logger.debug(ProductionNodeUtil.toString(nodeChain)
                            + " => "
                            + false);
                    nodeChain.clear();
                } else if (first instanceof INonTerminal) {
                    List<IProductionNode> chain = nodes.pop();
                    for (List<IProductionNode> expanded : expand(chain)) {
                        if (logger.isDebugEnabled()) {
                            logger.debug(ProductionNodeUtil.toString(nodeChain)
                                    + " => "
                                    + ProductionNodeUtil.toString(expanded));
                        }
                        nodes.push(expanded);
                    }
                }
            } else {
                // Remove the chain. This chain does terminate for sure
                // but there may be some others on the stack
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
        } else {
            logger.warn("Can not expand node:" + first.getName());
            result.add(new LinkedList<>(chain));
        }
        return result;
    }

}
