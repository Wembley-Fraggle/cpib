package ch.fhnw.cpib.test;

import static org.mockito.Mockito.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ch.fhnw.cpib.parsing.ParserException;
import ch.fhnw.cpib.parsing.rule.EmptyWord;
import ch.fhnw.cpib.parsing.rule.IEmptyWord;
import ch.fhnw.cpib.parsing.rule.INonTerminal;
import ch.fhnw.cpib.parsing.rule.IProduction;
import ch.fhnw.cpib.parsing.rule.IProductionNode;
import ch.fhnw.cpib.parsing.rule.ITerminal;
import ch.fhnw.cpib.parsing.rule.NonTerminal;
import ch.fhnw.cpib.parsing.rule.Production;
import ch.fhnw.cpib.parsing.rule.ProductionBuilder;
import ch.fhnw.cpib.parsing.rule.ProductionNodeUtil;
import ch.fhnw.cpib.parsing.rule.Syntax;
import ch.fhnw.cpib.parsing.rule.Terminal;

public class SyntaxTest {

    private Syntax syntax;
    private Syntax dragonSyntax;

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

        p = createProduction(e, t, eDash); // E->TE'
        dragonSyntax.register(p);

        p = createProduction(eDash, plus, t, eDash); // E' -> +TE'
        dragonSyntax.register(p);

        p = createProduction(eDash, emptyWord); // E' -> <empty>
        dragonSyntax.register(p);

        p = createProduction(t, f, tDash); // T -> FT'
        dragonSyntax.register(p);

        p = createProduction(tDash, times, f, tDash); // T' -> *FT'
        dragonSyntax.register(p);

        p = createProduction(tDash, emptyWord); // T' -> <empty>
        dragonSyntax.register(p);

        p = createProduction(f, brOpen, e, brClose); // F -> ( E )
        dragonSyntax.register(p);

        p = createProduction(f, id); // F -> ( E )
        dragonSyntax.register(p);

    }

    @Test
    public void testCanAddSameRuleTwice() throws ParserException {
        INonTerminal head = createNonTerminal("Hello");
        ITerminal terminal = createTerminal("World");
        IProduction production = createProduction(head, terminal);
        when(production.getHead()).thenReturn(head);
        
        syntax.register(production);
        syntax.register(production);

        Set<IProduction> result = syntax.getProductions("Hello");
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
    }

    @Test
    public void testFirstOfEmptyRule() throws ParserException {
        // X -> e
        IProduction production = mock(IProduction.class);
        IEmptyWord emptyWord = mock(IEmptyWord.class);
        List<IProductionNode> body = new LinkedList<IProductionNode>();
        body.add(emptyWord);

        INonTerminal head = mock(INonTerminal.class);
        when(head.getName()).thenReturn("X");
        when(production.getHead()).thenReturn(head);
        when(production.getBody()).thenReturn(body);
        when(production.isOptional()).thenReturn(true);

        dragonSyntax.register(production);

        Set<IProductionNode> result = dragonSyntax.getFirst("X");
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertTrue(result.toArray()[0] instanceof IEmptyWord);
    }

    private IProduction createProduction(INonTerminal head,
            IProductionNode... body) {
        List<IProductionNode> bodyList = new LinkedList<>();
        for (IProductionNode n : body) {
            bodyList.add(n);
        }
        IProduction production = mock(IProduction.class);
        when(production.getHead()).thenReturn(head);
        when(production.getBody()).thenReturn(bodyList);
        if(body.length > 0 && body[0] instanceof IEmptyWord) {
            when(production.isOptional()).thenReturn(true);
        }
        
        return production;
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

    @Test
    public void testDragonSampleWithNameFTE() throws ParserException {
        setupDragonBookSyntax();
        Set<IProductionNode> f = dragonSyntax.getFirst("F");
        Set<IProductionNode> t = dragonSyntax.getFirst("T");
        Set<IProductionNode> e = dragonSyntax.getFirst("E");

        Assert.assertNotNull(f);

        Assert.assertEquals(2, f.size());
        Assert.assertTrue(!ProductionNodeUtil.containsEmptyWord(f));
        Assert.assertTrue(ProductionNodeUtil.containsNode("(", f));
        Assert.assertTrue(ProductionNodeUtil.containsNode("id", f));
        Assert.assertEquals(f, t);
        Assert.assertEquals(t, e);
    }

    @Test
    public void testDragonSampleWithNamesEDash() throws ParserException {
        setupDragonBookSyntax();
        Set<IProductionNode> eDash = dragonSyntax.getFirst("E'");
        Assert.assertNotNull(eDash);

        Assert.assertEquals(2, eDash.size());
        Assert.assertTrue(ProductionNodeUtil.containsEmptyWord(eDash));
        Assert.assertTrue(ProductionNodeUtil.containsNode("+", eDash));
    }

    @Test
    public void testDragonSampleWithNamesTDash() throws ParserException {
        setupDragonBookSyntax();
        Set<IProductionNode> tDash = dragonSyntax.getFirst("T'");
        Assert.assertNotNull(tDash);

        Assert.assertEquals(2, tDash.size());
        Assert.assertTrue(ProductionNodeUtil.containsEmptyWord(tDash));
        Assert.assertTrue(ProductionNodeUtil.containsNode("*", tDash));
    }

}
