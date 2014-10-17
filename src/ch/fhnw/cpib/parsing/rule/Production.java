package ch.fhnw.cpib.parsing.rule;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

public class Production implements IProduction {
    private INonTerminal head;
    private List<IProductionNode> body;
    private static final Logger logger = Logger.getLogger(Production.class);

    public Production(INonTerminal head, List<IProductionNode> body) {
        if (head == null) {
            throw new IllegalArgumentException("Head must not be null");
        }
        if (body == null || body.size() == 0) {
            throw new IllegalArgumentException("Body must not be null or empty");
        }

        int emptyWordOffset = getEmptyWordOffset(body);
        if (emptyWordOffset > 0 && emptyWordOffset < body.size() - 1) {
            throw new IllegalArgumentException(
                    "empty word in body is not at the end");
        }

        this.head = head;
        this.body = new LinkedList<>(body);

    }

    public INonTerminal getHead() {
        return this.head;
    }

    public List<IProductionNode> getBody() {
        return new LinkedList<IProductionNode>(body);
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
        logger.debug("Looking for an empty word in nodes");
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i) instanceof IEmptyWord) {
                logger.debug("Empty word detected at index " + i);
                return i;
            }
        }
        logger.debug("No empty word in list");
        return -1;
    }
}
