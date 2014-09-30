package ch.fhnw.cpib.lexing;

import java.nio.channels.IllegalSelectorException;
import java.util.LinkedList;
import java.util.List;

public class LexerState implements ILexerState {

    private List<ITransition> transitions;

    public LexerState() {
        this.transitions = new LinkedList<>();
    }
    

    @Override
    public void addTransition(ITransition transition) {
        if (transitions == null) {
            throw new IllegalArgumentException("Transition must not be null");
        }

        this.transitions.add(transition);
    }

    @Override
    public ILexerState consume(ILexerContext ctx) throws LexerException {
        ITransition best = null;
        int bestSize = 0;
        for (ITransition tr : transitions) {
            int otherSize = tr.canConsume(ctx);
            if (otherSize > bestSize) {
                best = tr;
                bestSize = otherSize;
            }
        }
        if (best != null) {
            return best.consume(ctx);
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
