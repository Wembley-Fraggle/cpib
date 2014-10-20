package ch.fhnw.cpib.parsing.rule;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import ch.fhnw.cpib.parsing.ParserException;

// TODO Create an interface
// TODO Check for cyclic loops in First and Follow
// TOD More logging
public final class Syntax {
    private Set<IProduction> productionList;
    private static final Logger logger = Logger.getLogger(Syntax.class);

    public Syntax() {
        productionList = new LinkedHashSet<>();
    }

    public IProduction addProduction(INonTerminal head, IProductionNode... body) {
        IProduction production = new Production(this,head,body);
        productionList.add(production);
        return production;
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
    
    public Set<IProductionNode> getFirst(String name) throws ParserException {
        Set<IProductionNode> result = new LinkedHashSet<>();
        for(IProduction p : getProductions(name)) {
            result.addAll(p.getFirst());
        }
        return result;
    }
}
