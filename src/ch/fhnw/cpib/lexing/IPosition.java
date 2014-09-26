package ch.fhnw.cpib.lexing;

/**
 * Represents a position within a text. A text position can be determined 
 * either by its row and column or by the amount of characters relative
 * to the beginning of the text.
 */
public interface IPosition {
    /**
     * Gets the current line pointed to.
     * @return the current line to which the text positions points to.
     */
	int getCurrentLine();
	
	/**
	 * Gets the current column of the line pointed to.
	 * @return the current column within the line pointed to.
	 */
	int getCurrentColumn();
	
	/**
	 * Gets the character position within the text. The relative
	 * position is the defined by the number of characters to which
	 * the position points to.
	 * @return the relatrive position in the text this pointer points to.
	 */
	int getCharacterPosition();
}
