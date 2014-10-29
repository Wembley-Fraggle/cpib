package ch.fhnw.cpib.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ch.fhnw.cpib.parsing.ParserException;
import ch.fhnw.cpib.parsing.nodes.EmptyWord;
import ch.fhnw.cpib.parsing.nodes.IEmptyWord;
import ch.fhnw.cpib.parsing.nodes.INonTerminal;
import ch.fhnw.cpib.parsing.nodes.IProduction;
import ch.fhnw.cpib.parsing.nodes.IProductionNode;
import ch.fhnw.cpib.parsing.nodes.ITerminal;
import ch.fhnw.cpib.parsing.nodes.NonTerminal;
import ch.fhnw.cpib.parsing.nodes.Production;
import ch.fhnw.cpib.parsing.nodes.ProductionNodeUtil;
import ch.fhnw.cpib.parsing.nodes.Syntax;
import ch.fhnw.cpib.parsing.nodes.Terminal;

public class SyntaxTest {

    private Syntax syntax;
    private Syntax dragonSyntax;
    private IProduction productionE;
    private IProduction productionEDash;
    private IProduction productionEDashEmpty;
    private IProduction productionT;
    private IProduction productionTDash;
    private IProduction productionTDashEmpty;
    private IProduction productionFBracket;
    private IProduction productionFId;

    @Before
    public void setup() {
        syntax = new Syntax();
        dragonSyntax = new Syntax();
        setupDragonBookSyntax();
    }

    private void setupDragonBookSyntax() {
        ITerminal plus = createTerminal("+");
        ITerminal times = createTerminal("*");
        ITerminal brOpen = createTerminal("(");
        ITerminal brClose = createTerminal(")");
        ITerminal id = createTerminal("id");

        INonTerminal e = createNonTerminal("E");
        INonTerminal eDash = createNonTerminal("E'");
        INonTerminal t = createNonTerminal("T");
        INonTerminal tDash = createNonTerminal("T'");
        INonTerminal f = createNonTerminal("F");

        IEmptyWord emptyWord = new EmptyWord();

        IProduction p = null;

        // E->TE'
        productionE = dragonSyntax.addProduction(e, t, eDash);

        // E' -> +TE'
        productionEDash = dragonSyntax.addProduction(eDash, plus, t, eDash);

        // E' -> <empty>
        productionEDashEmpty = dragonSyntax.addProduction(eDash, emptyWord);

        // T -> FT'
        productionT = dragonSyntax.addProduction(t, f, tDash);

        // T' -> *FT'
        productionTDash = dragonSyntax.addProduction(tDash, times, f, tDash);

        // T' -> <empty>
        productionTDashEmpty = dragonSyntax.addProduction(tDash, emptyWord);

        // F -> ( E )
        productionFBracket = dragonSyntax.addProduction(f, brOpen, e, brClose);

        // F -> ( E )
        productionFId = dragonSyntax.addProduction(f, id);
    }

    @Test
    public void testCanAddSameRuleTwice() throws ParserException {
        INonTerminal head = createNonTerminal("Hello");
        ITerminal terminal = createTerminal("World");
        syntax.addProduction(head, terminal);

        Set<IProduction> result = syntax.getProductions("Hello");
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
    }

    @Test
    public void testFirstOfEmptyRule() throws ParserException {
        
        // X -> e
        IEmptyWord emptyWord = mock(IEmptyWord.class);
        INonTerminal head = mock(INonTerminal.class);

        when(head.getName()).thenReturn("X");
        IProduction p =  syntax.addProduction(head, emptyWord);

        Set<IProductionNode> result = p.getFirst();
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertTrue(result.toArray()[0] instanceof IEmptyWord);
    }

    private ITerminal createTerminal(String name) {
        return new Terminal(name);
    }

    private IEmptyWord createEmptyWord() {
        return new EmptyWord();
    }

    private INonTerminal createNonTerminal(String name) {
        return new NonTerminal(name);
    }

// TODO 
//    @Test
//    public void testDragonSampleWithNameFTE() throws ParserException {
//        // Resolve all by name
//        Set<IProductionNode> f = dragonSyntax.getFirst("F");
//        Set<IProductionNode> t = dragonSyntax.getFirst("T");
//        Set<IProductionNode> e = dragonSyntax.getFirst("E");
//
//        Assert.assertNotNull(f);
//
//        Assert.assertEquals(2, f.size());
//        Assert.assertTrue(!ProductionNodeUtil.containsEmptyWord(f));
//        Assert.assertTrue(ProductionNodeUtil.containsNode("(", f));
//        Assert.assertTrue(ProductionNodeUtil.containsNode("id", f));
//        Assert.assertEquals(f, t);
//        Assert.assertEquals(t, e);
//    }

// TODO 
//    @Test
//    public void testDragonSampleWithNamesEDash() throws ParserException {
//        // Resolve all by name
//        Set<IProductionNode> eDash = dragonSyntax.getFirst("E'");
//        Assert.assertNotNull(eDash);
//
//        Assert.assertEquals(2, eDash.size());
//        Assert.assertTrue(ProductionNodeUtil.containsEmptyWord(eDash));
//        Assert.assertTrue(ProductionNodeUtil.containsNode("+", eDash));
//    }
// TODO 
//    @Test
//    public void testDragonSampleWithNamesTDash() throws ParserException {
//        Set<IProductionNode> tDash = dragonSyntax.getFirst("T'");
//        Assert.assertNotNull(tDash);
//
//        Assert.assertEquals(2, tDash.size());
//        Assert.assertTrue(ProductionNodeUtil.containsEmptyWord(tDash));
//        Assert.assertTrue(ProductionNodeUtil.containsNode("*", tDash));
//    }
    
    @Test
    public void testDragonSampleWithProductionE() throws ParserException {
        // E -> TE'
        Set<IProductionNode> first = productionE.getFirst();
        Assert.assertNotNull(first);
        Assert.assertEquals(2, first.size());
        Assert.assertTrue(ProductionNodeUtil.containsNode("id", first));
        Assert.assertTrue(ProductionNodeUtil.containsNode("(", first));
    }

    @Test
    public void testDragonSampleWithProductionEDash() throws ParserException {
        // E' -> + T E'
        Set<IProductionNode> first = productionEDash.getFirst();
        Assert.assertNotNull(first);
        Assert.assertEquals(1, first.size());
        Assert.assertTrue(ProductionNodeUtil.containsNode("+", first));
    }
    
    @Test
    public void testDragonSampleWithProductionEDashEmpty() throws ParserException {
        // E' -> <e>
        Set<IProductionNode> first = productionEDashEmpty.getFirst();
        Assert.assertNotNull(first);
        Assert.assertEquals(1, first.size());
        Assert.assertTrue(ProductionNodeUtil.containsEmptyWord(first));
    }
    
    
    @Test
    public void testDragonSampleWithProductionT() throws ParserException {
        // T -> F T'
        Set<IProductionNode> first = productionT.getFirst();
        Assert.assertNotNull(first);
        Assert.assertEquals(2, first.size());
        Assert.assertTrue(ProductionNodeUtil.containsNode("(", first));
        Assert.assertTrue(ProductionNodeUtil.containsNode("id", first));
    }
    
    @Test
    public void testDragonSampleWithProductionTDash() throws ParserException {
        // T' -> * F T'
        Set<IProductionNode> first = productionTDash.getFirst();
        Assert.assertNotNull(first);
        Assert.assertEquals(1, first.size());
        Assert.assertTrue(ProductionNodeUtil.containsNode("*", first));
    }

    @Test
    public void testDragonSampleWithProductionTDashEmpty() throws ParserException {
        // T' -> e
        Set<IProductionNode> first = productionTDashEmpty.getFirst();
        Assert.assertNotNull(first);
        Assert.assertEquals(1, first.size());
        Assert.assertTrue(ProductionNodeUtil.containsEmptyWord(first));
    }
    
    
    
    @Test
    public void testDragonSampleWithProductionFId() throws ParserException {
        // F -> (E)
        Set<IProductionNode> first = productionFId.getFirst();
        Assert.assertNotNull(first);
        Assert.assertEquals(1, first.size());
        Assert.assertTrue(ProductionNodeUtil.containsNode("id", first));
    }
    
    @Test
    public void testDragonSampleWithProductionFBracket() throws ParserException {
        // F -> (id)
        Set<IProductionNode> first = productionFBracket.getFirst();
        Assert.assertNotNull(first);
        Assert.assertEquals(1, first.size());
        Assert.assertTrue(ProductionNodeUtil.containsNode("(", first));
    }
    
}
