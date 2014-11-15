package ch.fhnw.cpib.lexing;

import ch.fhnw.cpib.parsing.IParserTreeValue;

/**
 * <p>An IToken is the product of a lexing step. Tokens are used to
 * structure a sequence of characters into a sequence of objects, which allows
 * to analyse and parse these. Tokens are usually used to parse a
 * syntax and build  a programm.</p>
 * 
 * <p>
 * Within a text (or sequence of characters) a token is position within a text.
 * Therefore a token has an exact position and can be located in a textual
 * structure.
 * </p>
 * 
 * <p>Some tokens may have attributes. E.g. an identifier needs the information
 * of the identifier value.</p>
 */
public interface IToken extends IParserTreeValue {
    
    /**
     * The starting postion of the token.
     * @return The position within the text where the token starts.
     */
	IPosition getStart();
	
	/**
	 * Additional attributes may give some more metadata about the 
	 * token. E.g. identifier name or the litteral value of a number
	 * can be read from this token.
	 * 
	 * @return the token
	 */
	CharSequence getValue();
	
	// TODO 
	ITerminal getType();
	
}
