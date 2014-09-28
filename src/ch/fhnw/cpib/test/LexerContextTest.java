package ch.fhnw.cpib.test;

import static org.mockito.Mockito.mock;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ch.fhnw.cpib.lexing.IPosition;
import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.lexing.LexerContext;

public class LexerContextTest {

    @Test
    public void testTokensInitiallyEmpty() throws IOException {
        InputStream input = new ByteArrayInputStream("".getBytes());
        LexerContext ctx = new LexerContext(input);

        // Tokens is initially empty
        List<IToken> resultList = ctx.getTokens();
        Assert.assertNotNull(resultList);
        Assert.assertEquals(0, resultList.size());
    }

    @Test
    public void testTokensSizeIncreased() throws IOException {
        InputStream input = new ByteArrayInputStream("".getBytes());
        LexerContext ctx = new LexerContext(input);
        IToken token = mock(IToken.class);

        int oldsize = ctx.getTokens().size();

        // When added the list size is increased
        ctx.addToken(token);
        Assert.assertEquals(oldsize + 1, ctx.getTokens().size());
    }

    @Test
    public void testAddingOrder() throws IOException {
        InputStream input = new ByteArrayInputStream("".getBytes());
        LexerContext ctx = new LexerContext(input);
        IToken token1 = mock(IToken.class);
        IToken token2 = mock(IToken.class);

        ctx.addToken(token1);
        ctx.addToken(token2);
        List<IToken> resultList = ctx.getTokens();

        int token1Index = resultList.indexOf(token1);
        int token2Index = resultList.indexOf(token2);

        Assert.assertTrue(token1Index < token2Index);
    }

    @Test
    public void testSameAddedToken() throws IOException {
        InputStream input = new ByteArrayInputStream("".getBytes());
        LexerContext ctx = new LexerContext(input);
        IToken token = mock(IToken.class);
        ctx.addToken(token);
        List<IToken> resultList = ctx.getTokens();

        // The token added is the same (not only equal)
        Assert.assertSame(token, resultList.get(resultList.size() - 1));
    }

    @Test
    public void testImmutableAddToken() throws IOException {
        InputStream input = new ByteArrayInputStream("".getBytes());
        LexerContext ctx = new LexerContext(input);
        IToken token = mock(IToken.class);

        // result list is immutable. Token can not be injected from outside
        // by adding a token to a previous list
        List<IToken> resultList = ctx.getTokens();
        resultList.add(token);
        Assert.assertNotEquals(resultList.size(), ctx.getTokens().size());

        // resultlist is immutable. When added a token to the context, a
        // previous list does not change.
        resultList = ctx.getTokens();
        ctx.addToken(token);
        Assert.assertNotEquals(resultList.size(), ctx.getTokens().size());
    }

    @Test
    public void testGetTextBuffer() throws IOException {
        String text = "Mutters Mutter ist Grossmutter";
        InputStream input = new ByteArrayInputStream(text.getBytes());
        LexerContext ctx = new LexerContext(input);

        Assert.assertNotSame(text, ctx.getText());
        Assert.assertEquals(text.toString(), ctx.getText().toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullStream() throws IOException {
        new LexerContext(null);
    }

    @Test
    public void testInitialPosition() throws IOException {
        InputStream input = new ByteArrayInputStream("".getBytes());
        LexerContext ctx = new LexerContext(input);

        IPosition pos = ctx.getCurrentPosition();
        Assert.assertEquals(1, pos.getCurrentLine());
        Assert.assertEquals(1, pos.getCurrentColumn());
        Assert.assertEquals(0, pos.getCharacterPosition());
    }

    @Test
    public void testPositionsMoveInText() throws IOException {
        StringBuffer buffer = new StringBuffer();
        buffer.append("The\n");
        buffer.append("end is near");

        InputStream input = new ByteArrayInputStream(buffer.toString()
                .getBytes());
        LexerContext ctx = new LexerContext(input);

        int expectedPos = 3;
        ctx.movePosition(expectedPos);
        IPosition pos = ctx.getCurrentPosition();
        Assert.assertEquals(expectedPos, pos.getCharacterPosition());

        Assert.assertEquals(1, pos.getCurrentLine());
        Assert.assertEquals(4, pos.getCurrentColumn());
        Assert.assertEquals(expectedPos, pos.getCharacterPosition());

        if(System.lineSeparator().length() == 2) {
            // This is normmally on windows platforms where
            // the line separator is \r\n (aka carriage return\linefeed)
            // In that case, when moving over \r we are still on the same
            // line. 
            expectedPos++;
            ctx.movePosition(1);
            pos = ctx.getCurrentPosition();
            Assert.assertEquals(1, pos.getCurrentLine());
            Assert.assertEquals(5, pos.getCurrentColumn());
            Assert.assertEquals(expectedPos, pos.getCharacterPosition());
        }
        
        // Move over lineend (e.g. Windows Linefeed)
        expectedPos++;
        ctx.movePosition(1);

        pos = ctx.getCurrentPosition();
        Assert.assertEquals(2, pos.getCurrentLine());
        Assert.assertEquals(1, pos.getCurrentColumn());
        Assert.assertEquals(expectedPos, pos.getCharacterPosition());
        
        // Check character position of current line
        expectedPos++;
        ctx.movePosition(1);
        pos = ctx.getCurrentPosition();
        Assert.assertEquals(2, pos.getCurrentLine());
        Assert.assertEquals(2, pos.getCurrentColumn());
        Assert.assertEquals(expectedPos, pos.getCharacterPosition());
        
    }
}
