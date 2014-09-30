package ch.fhnw.cpib.lexing;

import java.util.regex.Pattern;


public class IdentifierTransition extends AbstractTransition implements ITransition{

    private static final Pattern pattern = Pattern.compile("([a-zA-Z][a-zA-Z0-9]*).*");
    private ILexerState nextState;
    
    public IdentifierTransition(ILexerState nextState) {
        super(pattern);
        this.nextState = nextState;
    }
    
    
    @Override
    public ILexerState consume(ILexerContext ctx) throws LexerException {
        int count = canConsume(ctx);
        
        CharSequence text = ctx.getTextFromCurrentPosition();
        CharSequence name = text.subSequence(0, count);
        
        Token t = new Token("IDENT",ctx.getCurrentPosition(),count,name);
        ctx.addToken(t);
        ctx.movePosition(count);
        return nextState;
    }

}
