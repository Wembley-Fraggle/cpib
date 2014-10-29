package ch.fhnw.cpib.test.tools;

import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ch.fhnw.cpib.parsing.ParserException;
import ch.fhnw.cpib.parsing.nodes.EmptyWord;
import ch.fhnw.cpib.parsing.nodes.IEmptyWord;
import ch.fhnw.cpib.parsing.nodes.IGrammar;
import ch.fhnw.cpib.parsing.nodes.INonTerminal;
import ch.fhnw.cpib.parsing.nodes.IProduction;
import ch.fhnw.cpib.parsing.nodes.ITerminal;
import ch.fhnw.cpib.parsing.nodes.NonTerminal;
import ch.fhnw.cpib.parsing.nodes.Syntax;
import ch.fhnw.cpib.parsing.nodes.Terminal;
import ch.fhnw.cpib.parsing.tools.FirstAnalyser;
import ch.fhnw.cpib.test.DragonGrammar;

public class FirstAnalyserTest {
    private IGrammar grammar;
    private DragonGrammar dragonGrammar;
    private FirstAnalyser analyser;
    private INonTerminal e;
    private IEmptyWord emptyWord;

    @Before
    public void setup() {
        grammar = new Syntax();
        analyser = new FirstAnalyser();
        dragonGrammar = new DragonGrammar();

        e = createNonTerminal("e");
        emptyWord = createEmptyWord();
    }

    private ITerminal createTerminal(String name) {
        ITerminal node = new Terminal(name);
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

    private IEmptyWord createEmptyWord() {
        IEmptyWord node = new EmptyWord();
        // IEmptyWord node = mock(IEmptyWord.class);
        // when(node.getName()).thenReturn("<empty word>");
        return node;
    }

    @Test
    public void testFirstOfEmptyRule() throws ParserException {

        // if E -> e => {}
        FirstAnalyser analyser = new FirstAnalyser(grammar);
        IProduction p = grammar.addProduction(e, emptyWord);

        Set<ITerminal> result = analyser.first(e);
        Assert.assertNotNull(result);
        Assert.assertEquals(0, result.size());
    }

    @Test
    public void testSimpleRules() {
        IEmptyWord empty = createEmptyWord();
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
        analyser.setGrammar(grammar);

        analyser.first(bN);
    }

    @Test
    public void testDragonSampleWithNameFTE() throws ParserException {
        // Resolve all by name
        analyser.setGrammar(dragonGrammar);
        Set<ITerminal> firstF = analyser.first(dragonGrammar.getF());
        Set<ITerminal> firstT = analyser.first(dragonGrammar.getT());
        Set<ITerminal> firstE = analyser.first(dragonGrammar.getE());

        Assert.assertNotNull(firstF);
        Assert.assertEquals(2, firstF.size());
        Assert.assertTrue(firstF.contains(dragonGrammar.getBrOpen()));
        Assert.assertTrue(firstF.contains(dragonGrammar.getId()));

        Assert.assertEquals(firstF, firstT);
        Assert.assertEquals(firstT, firstE);
    }

    @Test
    public void testDragonSampleWithNamesEDash() throws ParserException {
        // Resolve all by name
        analyser.setGrammar(dragonGrammar);

        Set<ITerminal> firstEDash = analyser.first(dragonGrammar.getEDash());
        Assert.assertNotNull(firstEDash);

        Assert.assertEquals(1, firstEDash.size());
        Assert.assertTrue(firstEDash.contains(dragonGrammar.getPlus()));
    }

    @Test
    public void testDragonSampleWithNamesTDash() throws ParserException {
        analyser.setGrammar(dragonGrammar);

        Set<ITerminal> firstTDash = analyser.first(dragonGrammar.getTDash());
        Assert.assertNotNull(firstTDash);

        Assert.assertEquals(1, firstTDash.size());
        Assert.assertTrue(firstTDash.contains(dragonGrammar.getTimes()));
    }

    @Test
    public void testDragonSampleWithProductionE() throws ParserException {
        // E -> TE'
        analyser.setGrammar(dragonGrammar);
        Set<ITerminal> first = analyser.first(dragonGrammar.getE());
        Assert.assertNotNull(first);
        Assert.assertEquals(2, first.size());
        Assert.assertTrue(first.contains(dragonGrammar.getId()));
        Assert.assertTrue(first.contains(dragonGrammar.getBrOpen()));
    }

    @Test
    public void testDragonSampleWithProductionEDash() throws ParserException {
        // E' -> + T E'
        analyser.setGrammar(dragonGrammar);
        Set<ITerminal> first = analyser.first(dragonGrammar.getEDash());
        Assert.assertNotNull(first);
        Assert.assertEquals(1, first.size());
        Assert.assertTrue(first.contains(dragonGrammar.getPlus()));
    }

    @Test
    public void testDragonSampleWithProductionT() throws ParserException {
        // T -> F T'
        analyser.setGrammar(dragonGrammar);
        Set<ITerminal> first = analyser.first(dragonGrammar.getT());
        Assert.assertNotNull(first);
        Assert.assertEquals(2, first.size());
        Assert.assertTrue(first.contains(dragonGrammar.getBrOpen()));
        Assert.assertTrue(first.contains(dragonGrammar.getId()));
    }
    


    @Test
    public void testDragonSampleWithProductionTDash() throws ParserException {
        // T' -> * F T'
        analyser.setGrammar(dragonGrammar);
        Set<ITerminal> first = analyser.first(dragonGrammar.getTDash());
        Assert.assertNotNull(first);
        Assert.assertEquals(1, first.size());
        Assert.assertTrue(first.contains(dragonGrammar.getTimes()));
    }
    

    @Test
    public void testDragonSampleWithProductionFId() throws ParserException {
        // F -> (E) | id
        analyser.setGrammar(dragonGrammar);
        Set<ITerminal> first = analyser.first(dragonGrammar.getF());
        Assert.assertNotNull(first);
        Assert.assertEquals(2, first.size());
        Assert.assertTrue(first.contains(dragonGrammar.getId()));
        Assert.assertTrue(first.contains(dragonGrammar.getBrOpen()));
    }
}
