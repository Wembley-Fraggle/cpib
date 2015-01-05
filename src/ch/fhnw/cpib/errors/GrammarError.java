package ch.fhnw.cpib.errors;

@SuppressWarnings("serial")
public class GrammarError extends Exception{

    public GrammarError() {
        super();
    }

    public GrammarError(String message, Throwable cause) {
        super(message, cause);
    }

    public GrammarError(String message) {
        super(message);
    }

    public GrammarError(Throwable cause) {
        super(cause);
    }
}
