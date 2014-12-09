package ch.fhnw.cpib.parsing;

import java.util.List;

import ch.fhnw.cpib.parsing.nodes.IProduction;
import ch.fhnw.cpib.parsing.nodes.IProductionNode;

public interface ITransformation {
    void transfer(ParserTree source, ParserTree target); 
}
