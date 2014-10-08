package ch.fhnw.cpib.lexing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

public final class LexerContext implements ILexerContext {

    private static final Logger logger = Logger.getLogger(LexerContext.class);
    private StringBuffer text;
    private List<IToken> tokenList = new LinkedList<>();
    private IPosition currentPosition;

    public LexerContext(InputStream stream) throws IOException {
        if (stream == null) {
            throw new IllegalArgumentException("stream must not be null");
        }

        text = new StringBuffer();
        currentPosition = new Position(1,1,0);
        InputStreamReader ioReader = new InputStreamReader(stream);
        BufferedReader reader = new BufferedReader(ioReader);

        try {
            String line = reader.readLine();

            while (line != null) {
                text.append(line);
                text.append('\n');
                line = reader.readLine();
            }
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                logger.warn("Ignored exception: " + e.getMessage(), e);
            }
        }
    }

    @Override
    public IPosition getCurrentPosition() {
        return currentPosition;
    }

    @Override
    public void movePosition(int count) {
        IPosition pos = getCurrentPosition();
        int offset = pos.getCharacterPosition();
        int line = pos.getCurrentLine();
        int col = pos.getCurrentColumn();
        
        if (offset + count > text.length()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        CharSequence text = getTextFromCurrentPosition();
        String passed = text.subSequence(0, count).toString();
        int newlineIndex = passed.indexOf('\n');
        while(newlineIndex > -1) {
            line++;
            col = 1;
            passed = passed.substring(newlineIndex+1);
            newlineIndex = passed.indexOf('\n');
        }
        col += passed.length();
        offset += count;
        currentPosition = new Position(line,col,offset);
        
    }

    @Override
    public void addToken(final IToken token) {
        tokenList.add(token);
    }

    @Override
    public List<IToken> getTokens() {
        return new LinkedList<>(tokenList);
    }

    @Override
    public CharSequence getText() {
        return new StringBuffer(text);
    }
    
    @Override
    public boolean isFinished() {
        return getCurrentPosition().getCharacterPosition() >= text.length();
    }
    
    @Override
    public CharSequence getTextFromCurrentPosition() {
        IPosition position = getCurrentPosition();
        return text.subSequence(position.getCharacterPosition() , text.length());
    }
}
