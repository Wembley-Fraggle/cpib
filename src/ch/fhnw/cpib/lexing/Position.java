package ch.fhnw.cpib.lexing;

public class Position implements IPosition {

    private int line;
    private int column;
    private int charPosition;
    
    public Position(int line, int column, int charPosition) {
        this.line = line;
        this.column = column;
        this.charPosition = charPosition;
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
}
