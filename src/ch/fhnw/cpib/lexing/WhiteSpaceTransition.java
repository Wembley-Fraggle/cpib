package ch.fhnw.cpib.lexing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WhiteSpaceTransition extends AbstractTransition implements ITransition {

    private static final Pattern pattern = Pattern.compile("(^\\s+).*");
    private ILexerState nextState;

    public WhiteSpaceTransition(ILexerState nextState) {
        super(pattern);
        this.nextState = nextState;
    }

    @Override
    public ILexerState consume(ILexerContext ctx) {
        int count = canConsume(ctx);
        ctx.movePosition(count);
        return nextState;
    }
}
