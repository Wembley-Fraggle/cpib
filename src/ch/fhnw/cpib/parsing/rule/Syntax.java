package ch.fhnw.cpib.parsing.rule;

import java.io.ObjectInputStream.GetField;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import ch.fhnw.cpib.parsing.ParserException;

// TODO Create an interface
public final class Syntax {
    private Set<IProduction> productionList;
    private static final Logger logger = Logger.getLogger(Syntax.class);

    public Syntax() {
        productionList = new LinkedHashSet<>();
    }

    public void register(IProduction production) {
        productionList.add(production);
    }

    public Set<IProduction> getProductions(INonTerminal nonterminal) {
        return getProductions(nonterminal.getName());
    }

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

    public Set<IProductionNode> getFirst(INonTerminal nonTerminal)
            throws ParserException {
        return getFirst(nonTerminal.getName());
    }

    public Set<IProductionNode> getFirst(String name) throws ParserException {
        Set<IProductionNode> result = new LinkedHashSet<>();

        if (name == null || name.length() == 0) {
            throw new IllegalArgumentException("name must not be null or empty");
        }
        for (IProduction p : getProductions(name)) {
            result.addAll(getFirst(p));
        }

        return result;
    }

    private Set<IProductionNode> getFirst(IProductionNode node)
            throws ParserException {
        Set<IProductionNode> result = new LinkedHashSet<IProductionNode>();
        // if the node is a terminal.
        // Then add the terminal to the result

        if (node instanceof ITerminal) {
            return getFirst((ITerminal) node);
        }
        if (node instanceof INonTerminal) {
            return getFirst((INonTerminal) node);
        }

        return result;

    }

    private Set<IProductionNode> getFirst(ITerminal node) {
        Set<IProductionNode> result = new LinkedHashSet<IProductionNode>();
        result.add(node);
        return result;
    }

    private Set<IProductionNode> getFirst(IProduction production)
            throws ParserException {
        
        Set<IProductionNode> result = new LinkedHashSet<>();
        if (production.isOptional()) {
            // there is a production such as X -> e
            result.add(new EmptyWord());
            return result;
        }
        
        
        int i = 0;
        boolean containsEmptyWord = true;
        List<IProductionNode> body = production.getBody();
        while (i < body.size() && containsEmptyWord) {

            // If X is a nonterminal and X + YlY2 . . - Yk is a production
            // for
            // some k >= 1, then place a in FIRST(X) if for some i, a is in
            // FIRST(Y[1]), and e is in all of FIRST(Y[1]), ... ,
            // FIRST(Y,i-1);
            // that is, Yl ... Y[i-1] *=> e.
            IProductionNode y = body.get(i);
            Set<IProductionNode> firstSet = getFirst(y);
            result.addAll(ProductionNodeUtil.removeEmptyWord(firstSet));
            containsEmptyWord = ProductionNodeUtil.containsEmptyWord(firstSet);
            i++;
        }

        if (containsEmptyWord) {
            // All contained the empty word. So the result is optional too
            result.add(new EmptyWord());
        }

        return result;
    }

  

}
