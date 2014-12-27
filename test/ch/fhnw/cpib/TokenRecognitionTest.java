package ch.fhnw.cpib;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ch.fhnw.cpib.lexing.EndMarker;
import ch.fhnw.cpib.lexing.IEndMarker;
import ch.fhnw.cpib.lexing.ITerminal;
import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.lexing.IlmLexer;
import ch.fhnw.cpib.lexing.LexerContext;
import ch.fhnw.cpib.lexing.LexerException;
import ch.fhnw.cpib.lexing.LexerRuleFactory;

public class TokenRecognitionTest {
    
    IlmLexer lexer;
    
    @Before
    public void setup() {
        LexerRuleFactory builder = new LexerRuleFactory();
        List<ITerminal> syntax = builder.create();
        lexer = new IlmLexer(syntax);
    }
    
    @Test
    public void testWhiteSpaces() throws LexerException, IOException {
        InputStream input = new ByteArrayInputStream("     ".toString().getBytes());
        List<IToken> tokenList = lexer.consume(input);
        
        // Whitespaces are ignored
        // The endmarker is the only one which is appended
        Assert.assertNotNull(tokenList);
        Assert.assertEquals(1, tokenList.size());
        IToken last = tokenList.get(0);
        Assert.assertTrue(last.getType() instanceof IEndMarker);
    }
    
    @Test
    public void testIdentifier() throws LexerException, IOException {
        InputStream input = new ByteArrayInputStream("     Liebe Grossmutter".toString().getBytes());
        List<IToken> tokenList = lexer.consume(input);
        

        Assert.assertNotNull(tokenList);
        // Whitespaces will be ignored
        Assert.assertEquals(3, tokenList.size());
        
        IToken t1 = tokenList.get(0);
        IToken t2 = tokenList.get(1);
        IToken t3 = tokenList.get(2);
        
        Assert.assertEquals("IDENTIFIER", t1.getType().getName());
        Assert.assertEquals("Liebe", t1.getValue());
        
        Assert.assertEquals("IDENTIFIER", t2.getType().getName());
        Assert.assertEquals("Grossmutter", t2.getValue());
        Assert.assertEquals(new EndMarker(), t3.getType());
        
        
    }
}
