package ch.fhnw.cpib.parsing;

import java.util.Iterator;
import java.util.List;

public interface IParseTree {

    Iterator<TreeNode> topDownIterator();

    ITreeNode getRootNode();

    void replace(ITreeNode old, TreeNode theNew);

    void swap(TreeNode first, TreeNode second);

    void removeNode(ITreeNode node);

    void setRoot(TreeNode root);

    void add(TreeNode parent, TreeNode child);

    List<TreeNode> getChildren(ITreeNode node);

    TreeNode getParent(ITreeNode node);

    boolean isLeaf(ITreeNode node);

}