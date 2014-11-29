package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.lexing.ITerminal;
import ch.fhnw.cpib.parsing.nodes.IProductionNode;

public class TerminalTreeNode extends TreeNode<ITerminal> {
    
    public TerminalTreeNode(ITerminal value) {
        super(value);
    }

    @Override
    public IProductionNode getProductionType() {
        return (IProductionNode)getValue();
    }
}
