package ch.fhnw.cpib.lexing;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

public class IlmLexer implements ILexer {

    private List<ITerminal> syntax;
    
    public IlmLexer(List<ITerminal> lexerStates) {
        this.syntax = new LinkedList<ITerminal>(lexerStates);
    }
    
    @Override
    public List<IToken> consume(InputStream text) throws LexerException, IOException {
        ILexerContext ctx = new LexerContext(text);
        
        while(!ctx.isFinished()) {
            consume(ctx);
        }
        IPosition lastPos = ctx.getCurrentPosition();
        IPosition endPos = new Position(lastPos.getCurrentLine()+1, 0,lastPos.getCharacterPosition()+1);
        ctx.addToken(new Token(new EndMarker(),endPos,""));
        
        return ctx.getTokens();
    }
    
    private void consume(ILexerContext ctx) throws LexerException {
        int bestSize = 0;
        List<ITerminal> candiates = new LinkedList<>();
        
        for (ITerminal type : syntax) {
            int otherSize = type.canConsume(ctx);
            if (otherSize > bestSize) {
                candiates.clear();
                bestSize = otherSize;
            }
            
            if(otherSize >= bestSize) {
                candiates.add(type);
            }
        }
        if (bestSize > 0) {
            // best is first candidate
            candiates.get(0).consume(ctx);
        }
        else 
        {
            StringBuilder msg = new StringBuilder();
            IPosition p = ctx.getCurrentPosition();

            msg.append("Unregonized token ");
            msg.append("at Line ").append(p.getCurrentLine()).append(" ");
            msg.append(", Column ").append(p.getCurrentColumn());

            throw new LexerException(msg.toString());
        }
    }
}
