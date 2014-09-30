package ch.fhnw.cpib.lexing;

public interface ITransition {
    ILexerState consume(ILexerContext ctx) throws LexerException;
    int canConsume(ILexerContext ctx);
}
