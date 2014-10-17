package ch.fhnw.cpib.parsing;

public final class ParserException extends Exception{

    public ParserException() {
        super();
    }

    public ParserException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParserException(String message) {
        super(message);
    }

    public ParserException(Throwable cause) {
        super(cause);
    }

}
