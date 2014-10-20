package ch.fhnw.cpib.parsing.rule;

import java.util.List;
import java.util.Set;

import ch.fhnw.cpib.parsing.ParserException;

public interface IProduction {
    public INonTerminal getHead();

    public List<IProductionNode> getBody();
    public Set<IProductionNode> getFirst() throws ParserException;
    public boolean isOptional();
}