package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.parsing.nodes.IProductionNode;

// TODO Remove Type safety
public abstract class TreeNode<V extends IParserTreeValue> implements ITreeNode<V> {
    private V value;
    
    public TreeNode(V value) {
        if(value == null) {
            throw new IllegalArgumentException("Value must not be null");
        }
        this.value = value;
    }
    
    /* (non-Javadoc)
     * @see ch.fhnw.cpib.parsing.ITreeNode#getProductionType()
     */
    @Override
    public abstract IProductionNode getProductionType();
    
    /* (non-Javadoc)
     * @see ch.fhnw.cpib.parsing.ITreeNode#getValue()
     */
    @Override
    public V getValue() {
        return this.value;
    }
    
}