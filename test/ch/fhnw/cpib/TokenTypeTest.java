package ch.fhnw.cpib;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import ch.fhnw.cpib.lexing.ILexerContext;
import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.lexing.ITokenType;
import ch.fhnw.cpib.lexing.LexerException;
import ch.fhnw.cpib.lexing.Terminal;

public class TokenTypeTest {

    private ILexerContext context;
    private Terminal wsIgnored;
    private Terminal ws;
    private Terminal intval;

    @Before
    public void setup() {
        context = mock(ILexerContext.class);
        wsIgnored = new Terminal("WS", "\\s+", true);
        ws = new Terminal("WS", "\\s+", false);
        intval = new Terminal("IDENTIFIER", "[A-Z][A-Z0-9]*");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMissingName() throws LexerException {
       new Terminal(null);
    }

    @Test
    public void testNullPatternAllowed() throws LexerException {

        when(context.getTextFromCurrentPosition()).thenReturn("Lorem ipsum");

        // empty pattern accepted. No exception expected
        Terminal type = new Terminal("TEST", null);
        int count = type.canConsume(context);

        // Due to missing pattern, no consumption is expected
        Assert.assertEquals(0, count);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullContext() throws LexerException {
        wsIgnored.canConsume(null);
    }

    @Test
    public void testCorrectGetters() {
        Assert.assertEquals("WS", wsIgnored.getName());
        Assert.assertEquals("\\s+", wsIgnored.getPattern());
        Assert.assertTrue(wsIgnored.isIgnore());

        // Does not ignore value
        Assert.assertFalse(ws.isIgnore());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullContextText() throws LexerException {
        when(context.getTextFromCurrentPosition()).thenReturn(null);
        wsIgnored.canConsume(context);
    }

    @Test
    public void testWhitespaceCanConsume() throws LexerException {
        when(context.getTextFromCurrentPosition()).thenReturn("     ");
        int count = ws.canConsume(context);
        Assert.assertEquals(5, count);

        verify(context).getTextFromCurrentPosition();
    }

    @Test
    public void testCanConsumeNotAtBeginning() throws LexerException {
        when(context.getTextFromCurrentPosition()).thenReturn("aaa     ");
        int count = ws.canConsume(context);
        Assert.assertEquals(0, count);

        verify(context).getTextFromCurrentPosition();
    }

    @Test
    public void testWhitespaceSingle() throws LexerException {
        when(context.getTextFromCurrentPosition()).thenReturn(" ");

        int count = ws.canConsume(context);
        Assert.assertEquals(1, count);

        verify(context).getTextFromCurrentPosition();
    }

    @Test
    public void testWhitespaceCanTab() throws LexerException {
        when(context.getTextFromCurrentPosition()).thenReturn("\t");
        int count = ws.canConsume(context);
        Assert.assertEquals(1, count);
        verify(context).getTextFromCurrentPosition();
    }

    @Test
    public void testWhitespaceCanNotConsume() throws LexerException {
        when(context.getTextFromCurrentPosition()).thenReturn("a");
        int count = ws.canConsume(context);
        Assert.assertEquals(0, count);
        verify(context).getTextFromCurrentPosition();
    }

    @Test
    public void testWSNoIgnoreConsumes() throws LexerException {
        when(context.getTextFromCurrentPosition()).thenReturn("   ");
        ws.consume(context);

        ArgumentCaptor<IToken> argument = ArgumentCaptor.forClass(IToken.class);
        verify(context, atLeastOnce()).getTextFromCurrentPosition();
        verify(context).addToken(argument.capture());

        IToken receivedArg = argument.getValue();
        Assert.assertNotNull(receivedArg);
        verify(context).movePosition(3);

        ITokenType receivedType = receivedArg.getType();
        Assert.assertNotNull(receivedType);
        Assert.assertEquals("WS", receivedType.getName());
    }

}
