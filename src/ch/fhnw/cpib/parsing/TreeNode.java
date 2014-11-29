package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.parsing.nodes.IProductionNode;

// TODO Remove Type safety
public abstract class TreeNode<V extends IParserTreeValue> {
    private V value;
    
    public TreeNode(V value) {
        if(value == null) {
            throw new IllegalArgumentException("Value must not be null");
        }
        this.value = value;
    }
    
    public abstract IProductionNode getProductionType();
    
    public V getValue() {
        return this.value;
    }
    
}