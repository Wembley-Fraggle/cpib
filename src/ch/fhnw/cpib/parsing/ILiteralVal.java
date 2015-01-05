package ch.fhnw.cpib.parsing;


public interface ILiteralVal {
    public enum Type {
        INT32,
        BOOL,
        PROC;
    }
    
    Type getType();
    int getValue();
    public String toString(final String indent);
}
