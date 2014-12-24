package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.parsing.nodes.IProductionNode;

public interface ITreeNode<V extends IParserTreeValue> {

    IProductionNode getProductionType();

    V getValue();

}