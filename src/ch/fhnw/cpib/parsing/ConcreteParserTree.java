package ch.fhnw.cpib.parsing;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import ch.fhnw.cpib.lexing.ITerminal;
import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.nodes.INonTerminal;
import ch.fhnw.cpib.parsing.nodes.IProduction;
import ch.fhnw.cpib.parsing.nodes.IProductionNode;

public class ConcreteParserTree extends ParserEventListenerAdapter {

    private TreeNode<IParserTreeValue> root;
    private Map<TreeNode<IParserTreeValue>, List<TreeNode<IParserTreeValue>>> childLinks;
    private Map<TreeNode<IParserTreeValue>, TreeNode<IParserTreeValue>> parentLinks;

    private List<TreeNode<IParserTreeValue>> orphanNonTerminals;
    private List<TreeNode<IParserTreeValue>> orphanTerminals;

    public ConcreteParserTree() {
        this.childLinks = new HashMap<>();
        this.parentLinks = new HashMap<>(); 
        orphanNonTerminals = new LinkedList<>();
        orphanTerminals = new LinkedList<>();
    }

    @Override
    public void onStart() {
        root = null;
    }

    public TreeNode<IParserTreeValue> getRootNode() {
        return root;
    }

    @Override
    public void output(IProduction production) {
        if (production == null) {
            throw new IllegalArgumentException("Production must not be null");
        }

        TreeNode<IParserTreeValue> headNode = addProductionHead(production);
        addProductionChildren(headNode, production);
    }

    private void addProductionChildren(TreeNode<IParserTreeValue> headNode,
            IProduction production) {
        if (production.getBody() == null) {
            throw new IllegalArgumentException(
                    "Production body must not be null");
        }

        List<TreeNode<IParserTreeValue>> children = childLinks.get(headNode);
        if(children == null) {
            throw new IllegalArgumentException("Headnode does not exist");
        }
        
        for (IProductionNode pn : production.getBody()) {
            TreeNode<IParserTreeValue> childNode = new TreeNode<IParserTreeValue>(
                    pn);
            addOrphan(childNode);
            children.add(childNode);
            childLinks.put(childNode, new LinkedList<TreeNode<IParserTreeValue>>());
            parentLinks.put(childNode, headNode);
        }
        if(children.size() > 0) {
            removeOrphan(headNode);
        }
    }

    private TreeNode<IParserTreeValue> addProductionHead(IProduction production) {
        INonTerminal head = production.getHead();
        if (head == null) {
            throw new IllegalArgumentException("Head must not be null");
        }
        TreeNode<IParserTreeValue> headNode;
        if (root == null) {
            headNode = new TreeNode<IParserTreeValue>(head);
            root = headNode;
            addOrphan(headNode);
        } else {
            headNode = getOrphan(head);
            if (headNode == null) {
                throw new IllegalArgumentException(
                        "Can not connect production to an existing non terminal");
            }
        }
        childLinks.put(headNode, new LinkedList<TreeNode<IParserTreeValue>>());
        return headNode;
    }

    private void addOrphan(TreeNode<IParserTreeValue> node) {
        IParserTreeValue value = node.getValue();
        if (value instanceof ITerminal) {
            orphanTerminals.add(node);
        } else if (value instanceof INonTerminal) {
            orphanNonTerminals.add(node);
        }
    }

    @Override
    public void output(IToken token) {
        if (token == null) {
            throw new IllegalArgumentException("Token must not be null");
        }
        if (root == null) {
            root = new TreeNode<IParserTreeValue>(token);
        } else {
            // Replace the Terminal which is linked by its
            // parent and 
            TreeNode<IParserTreeValue> node = getOrphan(token.getType());
            TreeNode<IParserTreeValue> parent = parentLinks.remove(node);
            removeOrphan(node);
            childLinks.remove(node);
            List<TreeNode<IParserTreeValue>> children = new LinkedList<>();
            TreeNode<IParserTreeValue> newNode = new TreeNode<IParserTreeValue>(token);
            children.add(newNode);
            childLinks.put(parent, children);
            parentLinks.put(newNode, parent);
            
        }
    }

    public List<TreeNode<IParserTreeValue>> getChildren(
            TreeNode<IParserTreeValue> node) {
        List<TreeNode<IParserTreeValue>> children = childLinks.get(node);
        if (children == null) {
            throw new IllegalArgumentException(
                    "Node not an element of this tree");
        }
        return new LinkedList<>(children);
    }

    public boolean isLeaf(TreeNode<IParserTreeValue> node) {
        List<TreeNode<IParserTreeValue>> children = childLinks.get(node);
        if (children == null) {
            throw new IllegalArgumentException(
                    "Node not an element of this tree");
        }
        
        return children.size() == 0;
    }

    private TreeNode<IParserTreeValue> getOrphan(INonTerminal type) {
        return getOrphan(type, orphanNonTerminals);
    }

    private TreeNode<IParserTreeValue> getOrphan(ITerminal type) {
        return getOrphan(type, orphanTerminals);
    }

    private void removeOrphan(TreeNode<IParserTreeValue> node) {
        orphanTerminals.remove(node);
        orphanNonTerminals.remove(node);
    }

    private TreeNode<IParserTreeValue> getOrphan(IProductionNode type,
            List<TreeNode<IParserTreeValue>> orphanList) {
        for (TreeNode<IParserTreeValue> node : orphanList) {
            if (node.getValue().equals(type)) {
                return node;
            }
        }
        return null;
    }
}
