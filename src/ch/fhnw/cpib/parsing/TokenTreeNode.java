package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.nodes.INonTerminal;
import ch.fhnw.cpib.parsing.nodes.IProductionNode;

public class TokenTreeNode extends TreeNode<IToken>{

    public TokenTreeNode(IToken value) {
        super(value);
    }

    public IProductionNode getProductionType() {
        return ((IToken)getValue()).getType();
    }
}
