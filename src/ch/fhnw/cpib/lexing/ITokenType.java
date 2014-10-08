package ch.fhnw.cpib.lexing;

public interface ITokenType {
    int canConsume(ILexerContext context) throws LexerException;
    void consume(ILexerContext context) throws LexerException;
    boolean isIgnore();
    boolean isType(String name);
    String getName();
    String getPattern();
    
}
