package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.errors.GrammarError;

public interface IParser {
    void parse() throws GrammarError;
}
