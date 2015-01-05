package ch.fhnw.cpib.lexing;

@SuppressWarnings("serial")
public class LexerException extends Exception{

    public LexerException() {
        super();
    }

    public LexerException(String message, Throwable cause) {
        super(message, cause);
    }

    public LexerException(String message) {
        super(message);
    }

    public LexerException(Throwable cause) {
        super(cause);
    }

}
