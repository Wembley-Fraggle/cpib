package ch.fhnw.cpib.parsing;

import java.util.LinkedList;
import java.util.List;

public class TreeNode<V> {
    private List<TreeNode<V>> children;
    private V value;
    
    public TreeNode() {
        children = new LinkedList<>();
    }
    
    public TreeNode(V value) {
        this();
        this.value = value;
    }
    
    public V getValue() {
        return this.value;
    }
    
}