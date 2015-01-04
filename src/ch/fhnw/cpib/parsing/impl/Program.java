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
        this.program4 = program4;
        this.doToken = doToken;
        this.cpsCmd = cpsCmd;
    }

		@Override
		public String toString(String indent) {
			return indent
					+ "<Program>\n"
					+ ident.toString(indent + '\t')
					+ progParamList.toString(indent + '\t')
					+ program1.toString(indent + '\t')
					+ program2.toString(indent + '\t')
					+ program3.toString(indent + '\t')
					+ cpsCmd.toString(indent + '\t')
					+ program4.toString(indent + '\t')
					+ indent
					+ "</Program>\n";
		}

		@Override
		public ch.fhnw.cpib.parsing.abs.IAbstSyn.IProgram toAbstrSyntax() {
			return null; //TODO
/*			return new ch.fhnw.cpib.parsing.abs.impl.Program(
	        ident, 
	        progParamList.toAbsSyn(), 
	        cpsCmd.toAbsSyn(),
	        program3.toAbsSyn(),
	        program4.toAbsSyn());  */
		} 
}
