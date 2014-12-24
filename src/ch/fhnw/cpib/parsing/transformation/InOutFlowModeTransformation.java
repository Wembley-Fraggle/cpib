package ch.fhnw.cpib.parsing.transformation;

import ch.fhnw.cpib.lexing.ITerminal;
import ch.fhnw.cpib.parsing.IGrammar;
import ch.fhnw.cpib.parsing.IParseTree;
import ch.fhnw.cpib.parsing.ITreeNode;
import ch.fhnw.cpib.parsing.ITreeSearch;
import ch.fhnw.cpib.parsing.TokenTypeTreeSearch;
import ch.fhnw.cpib.parsing.Transformation;
import ch.fhnw.cpib.parsing.TreeNode;
import ch.fhnw.cpib.parsing.nodes.INonTerminal;

public class InOutFlowModeTransformation extends Transformation{

    public InOutFlowModeTransformation(IGrammar grammar) {
        super(grammar);
    }
    
    @Override
    protected ITreeSearch getSearch() {
        IGrammar g = getGrammar();
        INonTerminal flowMode = g.getNonTerminal("flowMode");
        ITerminal inOut = g.getTerminal("INOUT");
        return new TokenTypeTreeSearch(flowMode, inOut);
    }

    @Override
    public void applyTransformation(ITreeNode node, IParseTree source,
            IParseTree target) {
        TreeNode flowModeIn = source.getChildren(node).get(0);
        target.replace(node, flowModeIn);
    }

}
