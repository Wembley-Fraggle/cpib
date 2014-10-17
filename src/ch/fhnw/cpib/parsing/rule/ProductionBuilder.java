package ch.fhnw.cpib.parsing.rule;

import java.util.LinkedList;
import java.util.List;

public final class ProductionBuilder {
    private INonTerminal head;
    private List<IProductionNode> body;
    
    public ProductionBuilder() {
        this.body = new LinkedList<IProductionNode>();
    }
    
    public void setHead(INonTerminal head) {
        this.head = head;
    }
    
    public void append(IProductionNode node) {
        body.add(node);
    }
    
    public IProduction build() {
        return new Production(head, body);
    }
}
