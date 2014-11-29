package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.nodes.IEmptyWord;
import ch.fhnw.cpib.parsing.nodes.IProductionNode;

public class EmptyWordTreeNode extends TreeNode<IEmptyWord>{

    public EmptyWordTreeNode(IEmptyWord value) {
        super(value);
    }

    public IProductionNode getProductionType() {
        return ((IEmptyWord)getValue());
    }
    
}
