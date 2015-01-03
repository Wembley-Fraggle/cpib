package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IProgram2;
import ch.fhnw.cpib.parsing.IProgram21;
import ch.fhnw.cpib.parsing.as.IAbsMother;

public class Program2 implements IProgram2{
    private IProgram21 program21;
    
    public Program2(IProgram21 program21) {
        this.program21 = program21;
    }

		@Override
		public IAbsMother toAbsSyn(IAbsMother prog) {
			// TODO Auto-generated method stub
			return program21.toAbsSyn(prog);
		}

}
