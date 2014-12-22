package ch.fhnw.cpib.parsing;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import ch.fhnw.cpib.parsing.nodes.IProduction;
import ch.fhnw.cpib.parsing.nodes.IProductionNode;

public abstract class Transformation implements ITransformation {
    private IProduction production;
    private IProductionNode head;
    private List<IProductionNode> body;

    public Transformation(IProduction production, IProductionNode... body) {
        this.production = production;
        this.body = new LinkedList<IProductionNode>(Arrays.asList(body));
    }

    @Override
    public void transfer(ParserTree source, ParserTree target) {
        TokenTypeTreeSearch search = new TokenTypeTreeSearch(
                production.getHead(), (IProductionNode[]) production.getBody()
                        .toArray());
        TreeNode node = search.search(source);
        while (node != null) {
            applyTransformation(node,source, target);
            node = search.search(source);
        }
    }

    public abstract void applyTransformation(TreeNode node,ParserTree source, ParserTree target);
}
