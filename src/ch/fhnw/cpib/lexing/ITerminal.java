package ch.fhnw.cpib.lexing;

import ch.fhnw.cpib.parsing.nodes.IProductionNode;

public interface ITerminal extends IProductionNode{
    int canConsume(ILexerContext context) throws LexerException;
    void consume(ILexerContext context) throws LexerException;
    boolean isIgnore();
    boolean isType(String name);
    String getName();
    String getPattern();
    
}
