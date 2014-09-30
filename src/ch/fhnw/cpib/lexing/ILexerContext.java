package ch.fhnw.cpib.lexing;

import java.util.List;

/**
 * A ILexerContext shares the information required for lexing. E.g. you can move
 * the lexing text pointer and request the current lexing position within the
 * text. All recognized tokens can also be stored in the context in oder to
 * build a chain of tokens.
 */
public interface ILexerContext {
    /**
     * TODO
     * 
     * @return
     */
    IPosition getCurrentPosition();

    /**
     * Move the lexing position within the text. Note that is is not allowed to
     * move before the initial text or after the last text position. This would
     * result in an {@link ArrayIndexOutOfBoundsException}.
     *
     * @param count
     *            number of characters to move the lexing positions. A positive
     *            position moves the lexer position forward, where a negative
     *            value will move the cursor backwards.
     */
    void movePosition(int count);

    /**
     * Adds a token to the context.
     *
     * @param token
     *            the token to be added to the context.
     */
    void addToken(IToken token);

    /**
     * Returns the list of actually added tokens.
     *
     * @return a list of tokens previously added.
     */
    List<IToken> getTokens();

    /**
     * Accessor for the text to be analysed.
     *
     * @return the text to be analysed by the lexer.
     */
    CharSequence getText();
    
    // TODO
    CharSequence getTextFromCurrentPosition();
    
    boolean isFinished();
}
