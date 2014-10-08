package ch.fhnw.cpib.lexing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TokenType implements ITokenType {

    private String name;
    private String patternStr;
    private Pattern pattern;
    private boolean ignore;

    public TokenType(String name) {
        if(name == null) {
            throw new IllegalArgumentException("name must not be null");
        }
        this.name = name;
    }

    public TokenType(String name, String pattern) {
        this(name);
        
        if(pattern != null) {
            this.patternStr = pattern;
            this.pattern = Pattern.compile("(" + pattern + ").*", Pattern.DOTALL);
        }
    }

    public TokenType(String name, String pattern, boolean ignore) {
        this(name, pattern);
        this.ignore = ignore;
    }

    @Override
    public int canConsume(ILexerContext context) throws LexerException {
        if(context == null)  {
            throw new IllegalArgumentException("context must not be null");
        }

        if (pattern == null) {
            return 0;
        }
        CharSequence text = context.getTextFromCurrentPosition();
        if(text == null) {
            throw new IllegalArgumentException("context text must not be null");
        }
        
        Matcher matcher = pattern.matcher(text);
        if (matcher.matches()) {
            return matcher.group(1).length();
        } else {
            return 0;
        }
    }

    @Override
    public void consume(ILexerContext context) throws LexerException {
        int count = canConsume(context);
        if (count > 0) {
            if (!this.isIgnore()) {
                CharSequence text = context.getTextFromCurrentPosition();
                IPosition start = context.getCurrentPosition();
                CharSequence value = text.subSequence(0, count);
                Token t = new Token(this, start, value);
                context.addToken(t);
            }
            context.movePosition(count);
        } else {
            throw new IllegalStateException("Can not consume type");
        }

    }

    @Override
    public boolean isType(String name) {
        if (getName().equals(name)) {
            return true;
        }

        return false;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean isIgnore() {
        return this.ignore;
    }

    @Override
    public String getPattern() {
       return patternStr;
    }

}
