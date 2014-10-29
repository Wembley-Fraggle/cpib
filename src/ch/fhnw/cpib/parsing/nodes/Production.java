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

    public Production(INonTerminal head,IProductionNode body, IProductionNode... optionalBody) {
        List<IProductionNode> wrappedBody = new LinkedList<>();
        if(body == null) {
            throw new IllegalArgumentException("Body must not be null");
        }
        wrappedBody.add(body);
        if(optionalBody != null) {
            for(IProductionNode n : optionalBody) {
                wrappedBody.add(n);
            }
        }
        init(head,wrappedBody);
    }
    
    public Production(INonTerminal head,List<IProductionNode> body) {
        init(head,body);
    }
    
    private void init(INonTerminal head, List<IProductionNode> body) {
        if (head == null) {
            throw new IllegalArgumentException("Head must not be null");
        }
        if(body == null || body.size() == 0) {
            throw new IllegalArgumentException("Body must not be null");
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

    public boolean contains(IProductionNode node) {
        for (IProductionNode n : body) {
            if (n.getName().equals(node.getName())) {
                return true;
            }
        }
        return false;
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
