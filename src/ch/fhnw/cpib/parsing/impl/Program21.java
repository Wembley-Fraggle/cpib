package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.ICpsDecl;
import ch.fhnw.cpib.parsing.IProgram21;
import ch.fhnw.cpib.parsing.as.IAbsMother;
import ch.fhnw.cpib.parsing.as.IAbsMother.IAbsDecl;

public class Program21 implements IProgram21{
    private IToken global;
    private ICpsDecl cpsDecl;
    
    public Program21(IToken global, ICpsDecl cpsDecl) {
        this.global = global;
        this.cpsDecl = cpsDecl;
    }

		@Override
		public IAbsDecl toAbsSyn(IAbsMother program) {
			// TODO Auto-generated method stub
			return cpsDecl.toAbsSyn();
		}

}
