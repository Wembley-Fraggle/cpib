package ch.fhnw.cpib.lexing;

import java.util.regex.Pattern;


public class NewLineTransition extends AbstractTransition implements ITransition{

    private static final Pattern pattern = Pattern.compile("\\n");
    private ILexerState nextState;
    
    public NewLineTransition(ILexerState nextState) {
        super(pattern);
        this.nextState = nextState;
    }

    @Override
    public ILexerState consume(ILexerContext ctx) throws LexerException {
        int count = canConsume(ctx);
        ctx.movePosition(count);
        return nextState;
        
    }

}
