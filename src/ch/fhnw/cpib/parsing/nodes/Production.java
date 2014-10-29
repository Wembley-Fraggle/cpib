package ch.fhnw.cpib.parsing.nodes;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import ch.fhnw.cpib.parsing.ParserException;

public class Production implements IProduction {
    private INonTerminal head;
    private List<IProductionNode> body;
    private static final Logger logger = Logger.getLogger(Production.class);
    private Syntax syntax;

    public Production(Syntax syntax, INonTerminal head,
            IProductionNode... body) {
        if (syntax == null) {
            throw new IllegalArgumentException("Syntax must not be null");
        }
        if (head == null) {
            throw new IllegalArgumentException("Head must not be null");
        }
        if (body == null || body.length == 0) {
            throw new IllegalArgumentException("Body must not be null or empty");
        }
        
        List<IProductionNode> bodyList = new LinkedList<>();
        for(IProductionNode node : body) {
            if(node == null) {
                throw new IllegalArgumentException("Node must not be null");
            }
                bodyList.add(node);
        }

        int emptyWordOffset = getEmptyWordOffset(bodyList);
        if (emptyWordOffset > 0 && emptyWordOffset < bodyList.size() - 1) {
            throw new IllegalArgumentException(
                    "empty word in body is not at the end");
        }

        this.syntax = syntax;
        this.head = head;
        this.body = bodyList;
    }


    public INonTerminal getHead() {
        return this.head;
    }

    public List<IProductionNode> getBody() {
        return new LinkedList<IProductionNode>(body);
    }

    public Set<IProductionNode> getFirst() throws ParserException {
        // TODO Check for cyclick loops
        
        Set<IProductionNode> result = new LinkedHashSet<>();
        if (isOptional()) {
            // there is a production such as X -> e
            result.add(new EmptyWord());
            return result;
        }

        int i = 0;
        boolean containsEmptyWord = true;
        List<IProductionNode> body = getBody();
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

    public Set<IProductionNode> getFirst(INonTerminal node)
            throws ParserException {
        if (node == null || node.getName().length() == 0) {
            throw new IllegalArgumentException("node must not be null or empty");
        }

        Set<IProductionNode> result = new LinkedHashSet<>();
        for (IProduction p : syntax.getProductions(node.getName())) {
            result.addAll(p.getFirst());
        }

        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Production: ");
        builder.append(head);
        builder.append(" ::= ");
        for (IProductionNode node : body) {
            builder.append(node.getName()).append(" ");
        }
        builder.delete(builder.length() - 1, builder.length());

        return builder.toString();
    }

    public boolean isOptional() {
        return getEmptyWordOffset(body) == 0;
    }

    private static int getEmptyWordOffset(List<IProductionNode> nodes) {
        return getOffsetPosition(nodes, IEmptyWord.class);
    }

    private static int getOffsetPosition(List<IProductionNode> nodes,
            Class<? extends IProductionNode> cls) {
        if (nodes == null) {
            throw new IllegalArgumentException("Nodes must not be null");
        }

        if (!cls.isInterface()) {
            throw new IllegalArgumentException("Class must be an interface");
        }

        for (int i = 0; i < nodes.size(); i++) {

            IProductionNode node = nodes.get(i);
            if (cls.isAssignableFrom(node.getClass())) {
                logger.debug("Found a node of given type "
                        + cls.getSimpleName() + " at index " + i);
                return i;
            }
        }

        logger.debug("No node of type " + cls.getSimpleName() + " found");
        return -1;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + body.hashCode();
        result = prime * result + head.hashCode();
        return result;
    }
}
