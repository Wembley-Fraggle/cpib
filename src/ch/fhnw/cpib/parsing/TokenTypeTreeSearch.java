package ch.fhnw.cpib.parsing;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import ch.fhnw.cpib.parsing.nodes.IProductionNode;

public class TokenTypeTreeSearch implements ITreeSearch{
    IProductionNode head;
    List<IProductionNode> body;

    public TokenTypeTreeSearch(IProductionNode head, IProductionNode... body) {
        this.head = head;
        if (body == null) {
            this.body = new LinkedList<IProductionNode>(Arrays.asList(body));
        } else {
            this.body = new LinkedList<>();
        }
    }

    public ITreeNode search(IParseTree tree) {
        Iterator<TreeNode> iter = tree.topDownIterator();        
        while(iter.hasNext()) {
            ITreeNode treeHead = searchHead(iter);
            if(treeHead != null && hasSameBody(tree, treeHead)) {
                return treeHead;
            }
        }
        
        return null;
    }
    
    private ITreeNode searchHead(Iterator<TreeNode> iter) {
        while (iter.hasNext()) {
            ITreeNode treeHead = iter.next();
            if (this.head.equals(treeHead.getProductionType())) {
                return treeHead;
            }
        }
        return null;
    }

    private boolean hasSameBody(IParseTree tree, ITreeNode treeHead) {
        List<TreeNode> treeChildren = tree.getChildren(treeHead);
        if (body.size() > treeChildren.size()) {
            return false;
        }
            
        int max = Math.min(body.size(), treeChildren.size());
        for (int i = 0; i < max; i++) {
            IProductionNode treeNodeType = treeChildren.get(i)
                    .getProductionType();
            if (!body.get(i).equals(treeChildren)) {
                return false;
            }
        }
        return true;
    }

}
