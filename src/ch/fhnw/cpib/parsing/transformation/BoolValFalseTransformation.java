package ch.fhnw.cpib.parsing.transformation;

import ch.fhnw.cpib.lexing.ITerminal;
import ch.fhnw.cpib.parsing.IGrammar;
import ch.fhnw.cpib.parsing.ITreeSearch;
import ch.fhnw.cpib.parsing.ParserTree;
import ch.fhnw.cpib.parsing.TokenTypeTreeSearch;
import ch.fhnw.cpib.parsing.Transformation;
import ch.fhnw.cpib.parsing.TreeNode;
import ch.fhnw.cpib.parsing.nodes.INonTerminal;

public class BoolValFalseTransformation extends Transformation{

    public BoolValFalseTransformation(IGrammar grammar) {
        super(grammar);
    }
    
    @Override
    protected ITreeSearch getSearch() {
        // TODO 
        IGrammar g = getGrammar();
        INonTerminal head = g.getNonTerminal("boolVal");
        ITerminal boolVal = g.getTerminal("FALSE");
        return new TokenTypeTreeSearch(head, boolVal);
    }

    @Override
    public void applyTransformation(TreeNode node, ParserTree source,
            ParserTree target) {
        TreeNode value = source.getChildren(node).get(0);
        target.replace(node, value);
    }

}
