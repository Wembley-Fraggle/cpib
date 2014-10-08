package ch.fhnw.cpib.lexing;

public interface ITokenType {
    int canConsume(ILexerContext context) throws LexerException;
    void consume(ILexerContext context) throws LexerException;
    ITokenType isA(ITokenType type);
    void ignore(boolean doIgnore);
    boolean ignore();
    boolean isType(String name);
    String getName();
    
}