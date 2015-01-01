package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.ICpsCmd;
import ch.fhnw.cpib.parsing.IProgParamList;
import ch.fhnw.cpib.parsing.IProgram;
import ch.fhnw.cpib.parsing.IProgram1;
import ch.fhnw.cpib.parsing.IProgram2;
import ch.fhnw.cpib.parsing.IProgram3;
import ch.fhnw.cpib.parsing.IProgram4;

public class Program implements IProgram {
    private IToken program;
    private IToken ident;
    private IProgParamList progParamList;
    private IProgram1 program1;
    private IProgram2 program2;
    private IProgram3 program3;
    private IToken doToken;
    private ICpsCmd cpsCmd;
    private IProgram4 program4;
    private IToken endProgram;

    public Program(IToken program, IToken ident, IProgParamList progParamList,
            IProgram1 program1, IProgram2 program2, IProgram3 program3,
            IToken doToken, ICpsCmd cpsCmd,IProgram4 program4, IToken endProgram) {
        this.program = program;
        this.ident = ident;
        this.progParamList = progParamList;
        this.program1 = program1;
        this.program2 = program2;
        this.program3 = program3;
        this.doToken = doToken;
        this.cpsCmd = cpsCmd;
    }
}
