package ch.fhnw.cpib.parsing.nodes;

import java.util.List;

public interface IProduction {
    public INonTerminal getHead();

    public List<IProductionNode> getBody();
}