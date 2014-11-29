package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.parsing.nodes.INonTerminal;
import ch.fhnw.cpib.parsing.nodes.IProductionNode;

public class NonTerminalTreeNode extends TreeNode<INonTerminal> {
   
    public NonTerminalTreeNode(INonTerminal value) {
        super(value);
    }

    public IProductionNode getProductionType() {
        return (IProductionNode) getValue();
    }
}
