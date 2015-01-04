package ch.fhnw.cpib.lexing;


public interface ITerminal {
    int canConsume(ILexerContext context) throws LexerException;
    void consume(ILexerContext context) throws LexerException;
    boolean isIgnore();
    boolean isType(String name);
    String getName();
    String getPattern();
    String toString(String indent);
}
