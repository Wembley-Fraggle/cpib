package ch.fhnw.cpib.parsing.transformation;

import ch.fhnw.cpib.lexing.ITerminal;
import ch.fhnw.cpib.parsing.IGrammar;
import ch.fhnw.cpib.parsing.ITreeSearch;
import ch.fhnw.cpib.parsing.ParserTree;
import ch.fhnw.cpib.parsing.TokenTypeTreeSearch;
import ch.fhnw.cpib.parsing.Transformation;
import ch.fhnw.cpib.parsing.TreeNode;
import ch.fhnw.cpib.parsing.nodes.INonTerminal;

public class OutFlowModeTransformation extends Transformation{

    public OutFlowModeTransformation(IGrammar grammar) {
        super(grammar);
    }
    
    @Override
    protected ITreeSearch getSearch() {
        IGrammar g = getGrammar();
        INonTerminal flowMode = g.getNonTerminal("flowMode");
        ITerminal out = g.getTerminal("OUT");
        return new TokenTypeTreeSearch(flowMode, out);
    }

    @Override
    public void applyTransformation(TreeNode head, ParserTree source,
            ParserTree target) {
        TreeNode out = source.getChildren(head).get(0);
        target.replace(head, out);
    }

}
