package ch.fhnw.cpib.test.tools;

import java.util.Set;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ch.fhnw.cpib.parsing.Grammar;
import ch.fhnw.cpib.parsing.IGrammar;
import ch.fhnw.cpib.parsing.ParserException;
import ch.fhnw.cpib.parsing.nodes.EmptyWord;
import ch.fhnw.cpib.parsing.nodes.IEmptyWord;
import ch.fhnw.cpib.parsing.nodes.INonTerminal;
import ch.fhnw.cpib.parsing.nodes.ITerminal;
import ch.fhnw.cpib.parsing.nodes.NonTerminal;
import ch.fhnw.cpib.parsing.nodes.Terminal;
import ch.fhnw.cpib.parsing.tools.NullableCheck;
import ch.fhnw.cpib.test.DragonGrammar;

public class NullableCheckTest {

    private IGrammar grammar;
    private DragonGrammar dragonGrammar;
    private NullableCheck analyser;
    private static final Logger logger = Logger.getLogger(NullableCheckTest.class);

    @Before
    public void setup() {
        grammar = new Grammar();
        dragonGrammar = new DragonGrammar();
        analyser = new NullableCheck(grammar);
    }

    private ITerminal createTerminal(String name) {
        ITerminal node  = new Terminal(name);
        // ITerminal node = mock(ITerminal.class);
        // when(node.getName()).thenReturn(name);
        return node;
    }

    private INonTerminal createNonTerminal(String name) {
        INonTerminal node = new NonTerminal(name);
        // INonTerminal node = mock(INonTerminal.class);
        // when(node.getName()).thenReturn(name);
        return node;
    }

    private IEmptyWord createEmpty() {
        IEmptyWord node = new EmptyWord();
        // IEmptyWord node = mock(IEmptyWord.class);
        // when(node.getName()).thenReturn("<empty word>");
        return node;
    }

    @Test
    public void testSimpleRules() {
        IEmptyWord empty = createEmpty();
        INonTerminal s = createNonTerminal("S");
        INonTerminal aN = createNonTerminal("A");
        INonTerminal bN = createNonTerminal("B");

        ITerminal aT = createTerminal("a");
        ITerminal bT = createTerminal("b");

        // S = AB
        // A := a
        // B := b
        // B := <e>
        grammar.addProduction(s, aN, bN);
        grammar.addProduction(aN, aT);
        grammar.addProduction(bN, bT);
        grammar.addProduction(bN, empty);

        Assert.assertFalse(analyser.isNullable(aN));
        Assert.assertTrue(analyser.isNullable(bN));
        Assert.assertFalse(analyser.isNullable(aN));
        logger.debug("------------------");
        Assert.assertFalse(analyser.isNullable(s));
    }
    
    @Test
    public void testDragonSampleWithProductionEDashEmpty()
            throws ParserException {
        // E' -> <e>
        analyser.setGrammar(dragonGrammar);
        Assert.assertTrue(analyser.isNullable(dragonGrammar.getEDash()));
    }
    


    @Test
    public void testDragonSampleWithProductionTDashEmpty()
            throws ParserException {
        // T' -> e
        analyser.setGrammar(dragonGrammar);
        Assert.assertTrue(analyser.isNullable(dragonGrammar.getTDash()));
    }
}
