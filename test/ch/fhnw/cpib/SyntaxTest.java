package ch.fhnw.cpib;

import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ch.fhnw.cpib.lexing.ITerminal;
import ch.fhnw.cpib.lexing.Terminal;
import ch.fhnw.cpib.parsing.EmptyWord;
import ch.fhnw.cpib.parsing.Grammar;
import ch.fhnw.cpib.parsing.IEmptyWord;
import ch.fhnw.cpib.parsing.INonTerminal;
import ch.fhnw.cpib.parsing.IProduction;
import ch.fhnw.cpib.parsing.NonTerminal;
import ch.fhnw.cpib.parsing.ParserException;

public class SyntaxTest {

    private DragonGrammar dragonGrammar;
    private Grammar grammar;
    
    @Before
    public void setup() {
        grammar = new Grammar();
        dragonGrammar = new DragonGrammar();
    }
    
    private ITerminal createTerminal(String name) {
        return new Terminal(name); // TODO Make it a mock
    }
    
    private INonTerminal createNonTerminal(String name) {
        return new NonTerminal(name); // TODO Make it a mock
    }
    
    private IEmptyWord createEmptyWord() {
        return new EmptyWord(); // TODO Make it a mock
    }


    @Test
    public void testCanAddSameRuleTwice() throws ParserException {
        INonTerminal head = createNonTerminal("Hello");
        ITerminal terminal = createTerminal("World");
        grammar.addProduction(head, terminal);

        Set<IProduction> result = grammar.getProductions("Hello");
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
    }
}
