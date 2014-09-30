package ch.fhnw.cpib.lexing;

public interface ILexerState {
    ILexerState consume(ILexerContext context) throws LexerException;
    void addTransition(ITransition transition);
}
