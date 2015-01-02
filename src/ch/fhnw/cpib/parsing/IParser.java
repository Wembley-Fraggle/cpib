package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.errors.GrammarError;

public interface IParser {
    IProgram parse() throws GrammarError;
}
