package ch.fhnw.cpib.parsing.tools;

import java.util.Set;

import ch.fhnw.cpib.lexing.ITerminal;
import ch.fhnw.cpib.parsing.IGrammar;
import ch.fhnw.cpib.parsing.ParserException;
import ch.fhnw.cpib.parsing.nodes.EndMarker;
import ch.fhnw.cpib.parsing.nodes.INonTerminal;
import ch.fhnw.cpib.parsing.nodes.IProduction;
import ch.fhnw.cpib.parsing.nodes.IProductionNode;

public class ParserTableBuilder {

    IGrammar grammar;
    NullableCheck nullableAnalyser;
    FirstAnalyser firstAnalyser;
    FollowAnalyser followAnalyser;

    public ParserTableBuilder grammar(IGrammar grammar) {
        if (grammar == null) {
            throw new IllegalArgumentException("Grammar must not be null");
        }

        this.grammar = grammar;
        return this;
    }

    public ParserTableBuilder first(FirstAnalyser tool) {
        this.firstAnalyser = tool;
        return this;
    }

    public ParserTableBuilder nullable(NullableCheck tool) {
        this.nullableAnalyser = tool;
        return this;
    }

    public ParserTableBuilder follow(FollowAnalyser tool) {
        this.followAnalyser = tool;
        return this;
    }

    public ParserTable build() throws ParserException {
        if (grammar == null) {
            throw new IllegalStateException("Grammar must be previously set");
        }

        if (nullableAnalyser == null) {
            nullableAnalyser = createDefaultNullableAnalyser();
        }
        if (firstAnalyser == null) {
            firstAnalyser = createDefaultFirstAnalyser();
        }
        if (followAnalyser == null) {
            followAnalyser = createDefaultFollowAnalyser();
        }
        firstAnalyser.setNullableAnalyser(nullableAnalyser);
        followAnalyser.setNullableAnalyser(nullableAnalyser);
        followAnalyser.setFirstAnalyser(firstAnalyser);

        ParserTable table = createParserTable();

        applyFirstRule(table);
        applySecondRule(table);
        return table;

    }

    private ParserTable createParserTable() {
        nullableAnalyser.setGrammar(grammar);
        firstAnalyser.setGrammar(grammar);
        followAnalyser.setGrammar(grammar);
        ParserTable table = new ParserTable();

        for (ITerminal t : grammar.getTerminals()) {
            table.addColumn(t);
        }
        table.addColumn(new EndMarker());
        for (INonTerminal nt : grammar.getNonTerminals()) {
            table.addRow(nt);
        }

        return table;
    }

    private void applyFirstRule(ParserTable table) throws ParserException {
        for (IProduction p : grammar.getProductions()) {
            Set<ITerminal> terminals = firstAnalyser.first(p.getBody());
            for (ITerminal t : terminals) {
                table.add(p.getHead(), t, p);
            }
        }
    }

    private void applySecondRule(ParserTable table) throws ParserException {
        for (IProduction p : grammar.getProductions()) {

            if (nullableAnalyser.isNullable(p.getBody())) {
                INonTerminal head = p.getHead();
                for (IProductionNode n : followAnalyser.follow(head)) {
                    table.add(head, n, p);
                }
            }
        }
    }

    private NullableCheck createDefaultNullableAnalyser() {
        return new NullableCheck();
    }

    private FirstAnalyser createDefaultFirstAnalyser() {
        return new FirstAnalyser();
    }

    private FollowAnalyser createDefaultFollowAnalyser() {
        return new FollowAnalyser();
    }

}
