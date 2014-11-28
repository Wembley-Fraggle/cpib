package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.parsing.nodes.IProductionNode;

// TODO Remove Type safety
public class TreeNode<V extends IParserTreeValue> {
    private V value;
    
    public TreeNode(V value) {
        if(value == null) {
            throw new IllegalArgumentException("Value must not be null");
        }
        this.value = value;
    }
    
    public IProductionNode getProductionType() {
        return null; // TODO 
    }
    
    public V getValue() {
        return this.value;
    }
    
}