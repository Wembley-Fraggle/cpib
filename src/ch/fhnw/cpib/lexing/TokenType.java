package ch.fhnw.cpib.lexing;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TokenType implements ITokenType {

    private String name;
    private Pattern pattern;
    private List<ITokenType> types;
    private boolean ignore;

    public TokenType(String name) {
        this.name = name;
        this.types = new LinkedList<>();
    }

    public TokenType(String name, String pattern) {
        this(name);
        this.pattern = Pattern.compile("(" + pattern + ").*", Pattern.DOTALL);
    }

    public TokenType(String name, String pattern, boolean ignore) {
        this(name, pattern);
        this.ignore = ignore;
    }

    @Override
    public int canConsume(ILexerContext context) throws LexerException {
        if (pattern == null) {
            return 0;
        }
        CharSequence text = context.getTextFromCurrentPosition();
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
            if (!this.ignore()) {
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

    public ITokenType isA(ITokenType type) {
        types.add(type);
        return type;
    }

    @Override
    public boolean isType(String name) {
        if (this.name.equals(name)) {
            return true;
        }
        for (ITokenType t : types) {
            if (t.isType(name)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void ignore(boolean doIgnore) {
        this.ignore = doIgnore;
    }

    @Override
    public boolean ignore() {
        return this.ignore;
    }

}
