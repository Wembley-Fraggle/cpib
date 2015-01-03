package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IInvariant;
import ch.fhnw.cpib.parsing.IProgram1;
import ch.fhnw.cpib.parsing.as.IAbsMother.IAbsInvariant;

public class Program1 implements IProgram1{
    private IInvariant inv;
    
    public Program1(IInvariant inv) {
        this.inv = inv;
    }

		@Override
		public IAbsInvariant toAbsSyn() {
			return inv.toAbsSyn();
		}
 
}
