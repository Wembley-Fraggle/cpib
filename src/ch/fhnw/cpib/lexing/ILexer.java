package ch.fhnw.cpib.lexing;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * A ILexerContext is the instance which analyses a sequence of characters in
 * order to structure it into (machine readable) tokens. The lexer is the first
 * of multiple steps which which are required to build a programm out of a
 * source code.
 */
public interface ILexer {

    /**
     * Consumes a text and converts it into tokens. If something could not be
     * analysed (e.g. an invalid sequence of characters stands in the text),
     * then a lexer can throw a LexerException.
     *
     * @param text
     *            the text to be analysed
     * @return a list of recognized tokens.
     */
    List<IToken> consume(InputStream text) throws LexerException, IOException;
}
