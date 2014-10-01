package ch.fhnw.cpib.test;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ch.fhnw.cpib.lexing.ITokenType;
import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.lexing.IlmLexer;
import ch.fhnw.cpib.lexing.LexerContext;
import ch.fhnw.cpib.lexing.LexerException;
import ch.fhnw.cpib.lexing.SyntaxBuilder;

public class TokenRecognitionTest {
    
    IlmLexer lexer;
    
    @Before
    public void setup() {
        SyntaxBuilder builder = new SyntaxBuilder();
        List<ITokenType> syntax = builder.build();
        lexer = new IlmLexer(syntax);
    }
    
    @Test
    public void testWhiteSpaces() throws LexerException, IOException {
        InputStream input = new ByteArrayInputStream("     ".toString().getBytes());
        List<IToken> tokenList = lexer.consume(input);
        
        // Whitespaces are ignored
        Assert.assertNotNull(tokenList);
        Assert.assertEquals(0, tokenList.size());
    }
    
    @Test
    public void testIdentifier() throws LexerException, IOException {
        InputStream input = new ByteArrayInputStream("     Liebe Grossmutter".toString().getBytes());
        List<IToken> tokenList = lexer.consume(input);
        

        Assert.assertNotNull(tokenList);
        // Whitespaces will be ignored
        Assert.assertEquals(2, tokenList.size());
        
        IToken t1 = tokenList.get(0);
        IToken t2 = tokenList.get(1);
        
        Assert.assertEquals("IDENTIFIER", t1.getType().getName());
        Assert.assertEquals("Liebe", t1.getValue());
        
        Assert.assertEquals("IDENTIFIER", t2.getType().getName());
        Assert.assertEquals("Grossmutter", t2.getValue());
        
        
        
    }
}
