package ch.fhnw.cpib.lexing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractTransition implements ITransition{

    private Pattern pattern;

    public AbstractTransition(Pattern pattern) {
        this.pattern = pattern;
    }
    
    @Override
    public int canConsume(ILexerContext ctx) {
        CharSequence text = ctx.getTextFromCurrentPosition();
        Matcher matcher = pattern.matcher(text);
        if (!matcher.matches()) {
            return 0;
        } else {
            if(matcher.groupCount() > 0) {
                return matcher.group(1).length();
            }
            else {
                return matcher.end();
            }
            
        }
    }

}