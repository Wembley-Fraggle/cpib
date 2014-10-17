package ch.fhnw.cpib.parsing.rule;

import java.util.List;

public interface IProduction {
    public INonTerminal getHead();

    public List<IProductionNode> getBody();
    public boolean isOptional();
}