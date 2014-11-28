package ch.fhnw.cpib.parsing;

import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Stack;

public class ParserTree {

    private TreeNode<IParserTreeValue> root;
    private Map<TreeNode, List<TreeNode>> parentToChildrenMap;
    private Map<TreeNode, TreeNode> childToParentMap;
    private int modCount = 0;

    public ParserTree() {
        modCount = 0;
        this.parentToChildrenMap = new HashMap<>();
        this.childToParentMap = new HashMap<>();
    }

    public ParserTree(final ParserTree other) {
        this.modCount = 0;
        this.root = other.root;
        this.parentToChildrenMap = new HashMap<>(other.parentToChildrenMap);
        this.childToParentMap = new HashMap<>(this.childToParentMap);

        for (TreeNode key : other.parentToChildrenMap.keySet()) {
            List<TreeNode> othersChilds = (List<TreeNode>) other.getParent(key);
            List<TreeNode> thisChilds = new LinkedList<>(othersChilds);
            this.parentToChildrenMap.put(key, thisChilds);
        }

        for (TreeNode key : other.childToParentMap.keySet()) {
            TreeNode othersChild = key;
            TreeNode otherParent = other.childToParentMap.get(key);
            this.childToParentMap.put(othersChild, otherParent);
        }

    }

    public final Iterator<TreeNode> topDownIterator() {
        return new TopDownIterator();
    }

    private class TopDownIterator implements Iterator<TreeNode> {
        private Stack<List<TreeNode>> unvisited;
        private int expectedModCount;

        public TopDownIterator(TreeNode node) {
            expectedModCount = modCount;
            unvisited = new Stack<>();
            if (node != null) {
                LinkedList<TreeNode> chain = new LinkedList<>();
                chain.add(node);
                unvisited.push(chain);
            }
        }

        public TopDownIterator() {
            this(getRootNode());
        }

        @Override
        public boolean hasNext() {
            return !unvisited.isEmpty();
        }

        @Override
        public TreeNode next() {
            checkForComodification();
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            List<TreeNode> chain = unvisited.peek();
            TreeNode<IParserTreeValue> current = chain.remove(0);
            if (chain.size() == 0) {
                unvisited.pop();
            }
            List<TreeNode> children = new LinkedList<>(getChildren(current));
            if (children.size() > 0) {
                unvisited.push(children);
            }
            return current;
        }

        final void checkForComodification() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
        }
    }

    public final TreeNode getRootNode() {
        return root;
    }
    
    public final void replace(TreeNode old, TreeNode theNew) {
        checkCanReplace(old, theNew);
        TreeNode parent = childToParentMap.remove(old);
        List<TreeNode> parentsChild = parentToChildrenMap.get(parent);
        int index = parentsChild.indexOf(old);
        while(index != -1) {
            // replace the node at the same position
            parentsChild.remove(index);
            parentsChild.add(index, theNew);
        }
        
        // Steal the old's node children
        childToParentMap.put(theNew, parent);
        List<TreeNode> children = parentToChildrenMap.get(old);
        parentToChildrenMap.put(theNew, children);
        parentToChildrenMap.remove(old);
        for(TreeNode child : children) {
            // Set the new parent
            childToParentMap.replace(child, theNew);
        }
    }

    private void checkCanReplace(TreeNode old, TreeNode theNew) {
        if(!parentToChildrenMap.containsKey(old)) {
            throw new IllegalArgumentException("Unknown node to be replaced");
        }
        
        if(parentToChildrenMap.containsKey(theNew)) {
            throw new IllegalArgumentException("New node already exists in this tree");
        }
    }

    public final void removeNode(TreeNode node) {
        List<TreeNode> childs = parentToChildrenMap.remove(node);
        if (childs != null) {
            for (TreeNode child : childs) {
                childToParentMap.remove(this);
            }
        }
        if (node == root) {
            root = null;
        }
        modCount++;
    }

    public final void setRoot(TreeNode root) {
        this.root = root;
        this.parentToChildrenMap = new HashMap<>();
        this.childToParentMap = new HashMap<>();
        modCount++;
    }

    public final void add(TreeNode parent, TreeNode child) {
        checkCanAdd(parent, child);
        List<TreeNode> children = parentToChildrenMap.get(parent);
        if (children == null) {
            children = new LinkedList<>();
            parentToChildrenMap.put(parent, children);
        }
        children.add(child);
        childToParentMap.put(child, parent);
        modCount++;
    }

    private final void checkCanAdd(TreeNode parent, TreeNode child) {
        if (root == null) {
            throw new IllegalStateException("root node not previously set");
        }

        if (!parentToChildrenMap.containsKey(parent)) {
            throw new IllegalArgumentException("Head node not found");
        }

        if (childToParentMap.containsKey(child)) {
            throw new IllegalArgumentException("Child previously added");
        }
        ;
    }

    public final List<TreeNode> getChildren(TreeNode node) {
        List<TreeNode> children = parentToChildrenMap.get(node);
        if (children == null) {
            throw new IllegalArgumentException(
                    "Node not an element of this tree");
        }
        return new LinkedList<>(children);
    }

    public final TreeNode getParent(TreeNode node) {
        return childToParentMap.get(node);
    }

    public final boolean isLeaf(TreeNode node) {
        List<TreeNode> children = parentToChildrenMap.get(node);
        if (children == null) {
            throw new IllegalArgumentException(
                    "Node not an element of this tree");
        }
        return children.size() == 0;
    }
}
