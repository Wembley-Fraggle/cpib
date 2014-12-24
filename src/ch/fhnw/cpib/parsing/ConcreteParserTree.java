package ch.fhnw.cpib.parsing;

import java.util.LinkedList;
import java.util.List;

import ch.fhnw.cpib.lexing.ITerminal;
import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.nodes.IEmptyWord;
import ch.fhnw.cpib.parsing.nodes.INonTerminal;
import ch.fhnw.cpib.parsing.nodes.IProduction;
import ch.fhnw.cpib.parsing.nodes.IProductionNode;


public final class ConcreteParserTree extends ParserTree implements IParserEventListener {

    private List<TreeNode> orphanNonTerminals;
    private List<TreeNode> orphanTerminals;

    public ConcreteParserTree() {
    }

    public ConcreteParserTree(ConcreteParserTree other) {
        super(other);
        orphanNonTerminals = new LinkedList<>(this.orphanNonTerminals);
        orphanTerminals = new LinkedList<>(this.orphanTerminals);
    }

    @Override
    public void onStart() {
        setRoot(null);
    }

    @Override
    public void output(IProduction production) {
        TreeNode<IParserTreeValue> headNode = getOrphan(production.getHead());
        if(headNode == null) {
            headNode = createTreeNode(production.getHead());
        }
        if(getRootNode() == null) {
            setRoot(headNode);
        }
        for(IProductionNode child : production.getBody()) {
            TreeNode childTreeNode = createTreeNode(child);
            addOrphan(childTreeNode);
            add(headNode,createTreeNode(child));
        }
        removeOrphan(headNode);
    }


    private TreeNode createTreeNode(IProductionNode pn) {
        if (pn instanceof ITerminal) {
            return new TerminalTreeNode((ITerminal) pn);
        }
        if (pn instanceof INonTerminal) {
            return new NonTerminalTreeNode((INonTerminal) pn);
        }
        if (pn instanceof IEmptyWord) {
            return new EmptyWordTreeNode((IEmptyWord) pn);
        }
        return null;
    }

    private TreeNode createTreeNode(IToken node) {
        return new TokenTreeNode(node);
    }

    @Override
    public void output(IToken token) {
        if (getRootNode() == null) {
            setRoot(createTreeNode(token));
        } else {
            // The terminal will be replaced by the concrete token
            ITreeNode terminalTreeNode = getOrphan(token.getType());
            replace(terminalTreeNode, createTreeNode(token));
            removeOrphan(terminalTreeNode);
        }
    }


    private TreeNode getOrphan(INonTerminal type) {
        return getOrphan(type, orphanNonTerminals);
    }

    private ITreeNode getOrphan(ITerminal type) {
        return getOrphan(type, orphanTerminals);
    }
    
    private void addOrphan(TreeNode<IParserTreeValue> node) {
        IParserTreeValue value = node.getValue();
        if (value instanceof ITerminal) {
            orphanTerminals.add(node);
        } else if (value instanceof INonTerminal) {
            orphanNonTerminals.add(node);
        }
    }

    private void removeOrphan(ITreeNode node) {
        orphanTerminals.remove(node);
        orphanNonTerminals.remove(node);
    }

    private TreeNode getOrphan(IProductionNode type,
            List<TreeNode> orphanList) {
        for (TreeNode<IParserTreeValue> node : orphanList) {
            if (node.getValue().equals(type)) {
                return node;
            }
        }
        return null;
    }

    @Override
    public void onEnd() {
    }
}
