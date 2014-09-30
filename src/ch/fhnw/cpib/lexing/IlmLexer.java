package ch.fhnw.cpib.lexing;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class IlmLexer implements ILexer {

    private ILexerState rootState;
    
    public IlmLexer(ILexerState rootState) {
        this.rootState = rootState;
    }
    
    @Override
    public List<IToken> consume(InputStream text) throws LexerException, IOException {
        ILexerContext ctx = new LexerContext(text);
        ILexerState currentState = rootState;
        
        while(!ctx.isFinished()) {
            currentState = currentState.consume(ctx);
        }
        
        return ctx.getTokens();
    }
}
