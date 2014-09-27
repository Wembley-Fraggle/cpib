package ch.fhnw.cpib.lexing;

public final class Position implements IPosition {

    private int line;
    private int column;
    private int charPosition;
    
    /**
     * Creates a new instance of a positon taking all parameters
     * required to determine a position.
     * 
     * @param line the line which is pointed to.
     * @param column the column in the given line which marks the position.
     * @param charPosition the alternative value, the position in the character
     * sequence.
     */
    public Position(int line, int column, int charPosition) {
        this.line = line;
        this.column = column;
        this.charPosition = charPosition;
    }
    
    /**
     * Copy constructor of this instance. This can be used to clone an instance
     * @param other the instance to be cloned.
     */
    public Position(Position other)
    {
        this.line = other.line;
        this.column = other.column;
        this.charPosition = other.charPosition;
    }
    
    @Override
    public int getCurrentLine() {
       return line;
    }

    @Override
    public int getCurrentColumn() {
        return column;
    }

    @Override
    public int getCharacterPosition() {
        return charPosition;
    }
    
    /**
     * Creates a new instance of this, having the same values that this
     * instance also has.
     */
    public Position clone() {
        return new Position(this);
    }
}
