package ch.fhnw.cpib.lexing;

import java.util.regex.Pattern;

public class WhileTransition extends AbstractTransition implements ITransition {

    private static final Pattern pattern = Pattern.compile("(^while).*");
    private ILexerState nextState;
    
    public WhileTransition(ILexerState nextState) {
        super(pattern);
        this.nextState = nextState;
    }
    
    @Override
    public ILexerState consume(ILexerContext ctx) throws LexerException {
        int count = canConsume(ctx);
        ctx.addToken(new Token("WHILE", ctx.getCurrentPosition(),count));
        return nextState;
    }
}
