package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.ICpsCmd;
import ch.fhnw.cpib.parsing.IProgParamList;
import ch.fhnw.cpib.parsing.IProgram;
import ch.fhnw.cpib.parsing.IProgram1;
import ch.fhnw.cpib.parsing.IProgram2;
import ch.fhnw.cpib.parsing.IProgram3;
import ch.fhnw.cpib.parsing.IProgram4;
import ch.fhnw.cpib.parsing.as.IAbsMother;
import ch.fhnw.cpib.parsing.as.IAbsMother.IAbsMotherCopy;
import ch.fhnw.cpib.parsing.as.impl.AbsMother;
import ch.fhnw.cpib.parsing.as.impl.AbsMotherCopy;

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
        this.program4 = program4;
        this.doToken = doToken;
        this.cpsCmd = cpsCmd;
    }

		@Override
		public IAbsMother toAbsSyn() {
			System.out.println("ParamList: " + progParamList.toAbsSyn());
			System.out.println("Program1: " + program1);
			IAbsMotherCopy prog = new AbsMotherCopy(ident, progParamList.toAbsSyn(), program1.toAbsSyn());
			System.out.println("program2: " + program2);
			System.out.println("program3: " + program3);
			System.out.println("cpsCmd: " + cpsCmd);
			System.out.println("program4: " + program4);
			IAbsMother prog2 = new AbsMother(prog, program2.toAbsSyn(prog), program3.toAbsSyn(), cpsCmd.toAbsSyn(), program4.toAbsSyn());
			return prog2;
		}
}
