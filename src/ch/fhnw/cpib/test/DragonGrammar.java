package ch.fhnw.cpib.test;

import java.util.Set;

import ch.fhnw.cpib.parsing.IGrammar;
import ch.fhnw.cpib.parsing.nodes.EmptyWord;
import ch.fhnw.cpib.parsing.nodes.IEmptyWord;
import ch.fhnw.cpib.parsing.nodes.INonTerminal;
import ch.fhnw.cpib.parsing.nodes.IProduction;
import ch.fhnw.cpib.parsing.nodes.IProductionNode;
import ch.fhnw.cpib.parsing.nodes.ITerminal;
import ch.fhnw.cpib.parsing.nodes.NonTerminal;
import ch.fhnw.cpib.parsing.nodes.Grammar;
import ch.fhnw.cpib.parsing.nodes.Terminal;

public class DragonGrammar implements IGrammar {

    private IGrammar grammarDelegate;
    private IProduction productionE;
    private IProduction productionEDash;
    private IProduction productionEDashEmpty;
    private IProduction productionT;
    private IProduction productionTDash;
    private IProduction productionTDashEmpty;
    private IProduction productionFBracket;
    private IProduction productionFId;
    private ITerminal plus;
    private ITerminal times;
    private ITerminal brOpen;
    private ITerminal brClose;
    private ITerminal id;

    private INonTerminal e;
    private INonTerminal eDash;
    private INonTerminal t;
    private INonTerminal tDash;
    private INonTerminal f;
    private IEmptyWord emptyWord;

    private ITerminal createTerminal(String name) {
        return new Terminal(name); // TODO Make it a mock
    }

    private INonTerminal createNonTerminal(String name) {
        return new NonTerminal(name); // TODO Make it a mock
    }

    private IEmptyWord createEmptyWord() {
        return new EmptyWord(); // TODO Make it a mock
    }

    public DragonGrammar() {
        grammarDelegate = new Grammar();
        plus = createTerminal("+");
        times = createTerminal("*");
        brOpen = createTerminal("(");
        brClose = createTerminal(")");
        id = createTerminal("id");

        e = createNonTerminal("E");
        eDash = createNonTerminal("E'");
        t = createNonTerminal("T");
        tDash = createNonTerminal("T'");
        f = createNonTerminal("F");
        emptyWord = new EmptyWord();

        // S -> E
        grammarDelegate.setStartSymbol(e);

        // E->TE'
        productionE = grammarDelegate.addProduction(e, t, eDash);

        // E' -> +TE'
        productionEDash = grammarDelegate.addProduction(eDash, plus, t, eDash);

        // E' -> <empty>
        productionEDashEmpty = grammarDelegate.addProduction(eDash, emptyWord);

        // T -> FT'
        productionT = grammarDelegate.addProduction(t, f, tDash);

        // T' -> *FT'
        productionTDash = grammarDelegate.addProduction(tDash, times, f, tDash);

        // T' -> <empty>
        productionTDashEmpty = grammarDelegate.addProduction(tDash, emptyWord);

        // F -> ( E )
        productionFBracket = grammarDelegate.addProduction(f, brOpen, e,
                brClose);

        // F -> id
        productionFId = grammarDelegate.addProduction(f, id);
    }

    public IProduction getProductionE() {
        return productionE;
    }

    public IProduction getProductionEDash() {
        return productionEDash;
    }

    public IProduction getProductionEDashEmpty() {
        return productionEDashEmpty;
    }

    public IProduction getProductionT() {
        return productionT;
    }

    public IProduction getProductionTDash() {
        return productionTDash;
    }

    public IProduction getProductionTDashEmpty() {
        return productionTDashEmpty;
    }

    public IProduction getProductionFBracket() {
        return productionFBracket;
    }

    public IProduction getProductionFId() {
        return productionFId;
    }

    public ITerminal getPlus() {
        return plus;
    }

    public ITerminal getTimes() {
        return times;
    }

    public ITerminal getBrOpen() {
        return brOpen;
    }

    public ITerminal getBrClose() {
        return brClose;
    }

    public ITerminal getId() {
        return id;
    }

    public INonTerminal getE() {
        return e;
    }

    public INonTerminal getEDash() {
        return eDash;
    }

    public INonTerminal getT() {
        return t;
    }

    public INonTerminal getTDash() {
        return tDash;
    }

    public INonTerminal getF() {
        return f;
    }

    @Override
    public IProduction addProduction(INonTerminal head, IProductionNode body,
            IProductionNode... optionalBody) {
        return grammarDelegate.addProduction(head, body, optionalBody);
    }

    @Override
    public Set<IProduction> getProductions(INonTerminal nonterminal) {
        return grammarDelegate.getProductions(nonterminal);
    }

    @Override
    public Set<IProduction> getProductions() {
        return grammarDelegate.getProductions();
    }

    @Override
    public Set<IProduction> getProductions(String name) {
        return grammarDelegate.getProductions(name);
    }

    @Override
    public Set<ITerminal> getTerminals() {
        return grammarDelegate.getTerminals();
    }

    @Override
    public Set<INonTerminal> getNonTerminals() {
        return grammarDelegate.getNonTerminals();
    }

    @Override
    public INonTerminal getStartSymbol() {
        return grammarDelegate.getStartSymbol();
    }

    @Override
    public void setStartSymbol(INonTerminal symbol) {
        grammarDelegate.setStartSymbol(symbol);
    }

    @Override
    public boolean isStartSymbol(INonTerminal node) {
        return grammarDelegate.isStartSymbol(node);
    }

}
