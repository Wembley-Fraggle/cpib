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
    private int currentOffset = 0;
    private int lineOffset = 0;
    private int currentLineIndex = 0;
    private List<Integer> lineOffsetList;

    public LexerContext(InputStream stream) throws IOException {
        if (stream == null) {
            throw new IllegalArgumentException("stream must not be null");
        }

        text = new StringBuffer();
        lineOffsetList = new LinkedList<Integer>();
        InputStreamReader ioReader = new InputStreamReader(stream);
        BufferedReader reader = new BufferedReader(ioReader);

        int separatorSize = System.lineSeparator().length();

        try {
            int textOffset = 0;
            String line = reader.readLine();
            if (line == null) {
                lineOffsetList.add(0);
            }

            while (line != null) {
                text.append(line);
                text.append('\n');
                lineOffsetList.add(textOffset);
                textOffset += line.length() + separatorSize;
                line = reader.readLine();
            }
            if (text.length() > 0) {
                text.replace(text.length() - 1, text.length(), "");
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
        int lineIndex = 0;
        while (lineIndex < lineOffsetList.size() &&
                lineOffsetList.get(lineIndex) <= currentOffset) {
            lineIndex++;
        }
        lineIndex--;
        int column = currentOffset - lineOffsetList.get(lineIndex);

        return new Position(lineIndex + 1, column + 1, currentOffset);
    }

    @Override
    public void movePosition(int count) {
        if (currentOffset + count > text.length()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        currentOffset += count;
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
}