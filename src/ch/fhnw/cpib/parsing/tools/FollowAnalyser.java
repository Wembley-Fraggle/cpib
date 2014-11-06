package ch.fhnw.cpib.parsing.tools;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import org.apache.log4j.Logger;

import ch.fhnw.cpib.parsing.IGrammar;
import ch.fhnw.cpib.parsing.nodes.EndMarker;
import ch.fhnw.cpib.parsing.nodes.INonTerminal;
import ch.fhnw.cpib.parsing.nodes.IProduction;
import ch.fhnw.cpib.parsing.nodes.IProductionNode;
import ch.fhnw.cpib.parsing.nodes.Production;

public class FollowAnalyser {
    private IGrammar grammar;
    private Stack<List<IProductionNode>> nodes;
    private static final Logger logger = Logger.getLogger(FollowAnalyser.class);
    private NullableCheck nullChecker;
    private FirstAnalyser firstAnalyser;

    public FollowAnalyser() {
    }

    public FollowAnalyser(IGrammar grammar) {
        if (grammar == null) {
            throw new IllegalArgumentException("Grammar must not be null");
        }
        this.grammar = grammar;
    }

    public IGrammar getGrammar() {
        return grammar;
    }

    public void setGrammar(IGrammar grammar) {
        if (grammar == null) {
            throw new IllegalArgumentException("Grammar must not be null");
        }
        this.grammar = grammar;
    }
    
    public void setNullableAnalyser(NullableCheck tool) {
        nullChecker = tool;
    }

    public void setFirstAnalyser(FirstAnalyser tool) {
        firstAnalyser = tool;
    }

    public Set<IProductionNode> follow(INonTerminal nonTerminal) {
        if (nonTerminal == null) {
            throw new IllegalArgumentException("nonTerminal must not be null");
        }

        if (grammar == null) {
            throw new IllegalStateException("Grammar must be previously set");
        }

        Stack<IProduction> nodes = new Stack<>();
        for (IProduction p : expand(nonTerminal)) {
            nodes.push(p);
        }
        return follow(nodes); 
    }

    private Set<IProductionNode> follow(Stack<IProduction> nodes) {
        if (grammar == null) {
            throw new IllegalStateException("Grammar must be pre");
        }
        if (nodes == null || nodes.size() == 0) {
            throw new IllegalStateException("Nodes must not be null or empty");
        }
        if (nullChecker == null) {
            nullChecker = createDefaultNullableAnalyser();
        }
        if (firstAnalyser == null) {
            firstAnalyser = createDefaultFirstAnalyser();
        }

        Set<IProductionNode> result = new LinkedHashSet<>();
        List<INonTerminal> resolved = new LinkedList<>();
        while (!nodes.isEmpty()) {
            IProduction production = nodes.pop();

            List<IProductionNode> body = new LinkedList<>(production.getBody());
            INonTerminal nonTerminal = (INonTerminal) body.remove(0);
            if (grammar.isStartSymbol(nonTerminal)) {
                result.add(new EndMarker());
            }
            result.addAll(firstAnalyser.first(body));
            if (body.size() == 0 || nullChecker.isNullable(body)) {
                if (resolved.contains(production.getHead())) {
                    logger.debug("Recursion resolved " + production);
                } else {
                    // FOLLOW(A->ab) = FIRST(b) u FOLLOW(A) if b is nullable
                    for (IProduction p : expand(production.getHead())) {
                        nodes.push(p);
                    }
                }
            }
            resolved.add(nonTerminal);
        }

        return result;
    }

    private List<IProduction> expand(INonTerminal nt) {
        List<IProduction> result = new LinkedList<IProduction>();
        for (IProduction p : grammar.getProductions()) {

            List<IProductionNode> chain = p.getBody();
            int index = chain.indexOf(nt);
            while (index > -1) {
                chain = chain.subList(index, chain.size());
                List<IProductionNode> chainClone = new LinkedList<>(chain);
                result.add(new Production(p.getHead(), chainClone));
                if (chain.size() > 0) {
                    chain.remove(0);
                }
                index = chain.indexOf(nt);
            }
        }
        return result;
    }

    private NullableCheck createDefaultNullableAnalyser() {
        NullableCheck tool = new NullableCheck();
        tool.setGrammar(getGrammar());
        return tool;
    }

    private FirstAnalyser createDefaultFirstAnalyser() {
        FirstAnalyser tool = new FirstAnalyser();
        tool.setGrammar(getGrammar());
        return tool;
    }

}
