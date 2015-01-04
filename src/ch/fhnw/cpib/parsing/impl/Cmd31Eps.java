package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.ICmd31;
import ch.fhnw.cpib.parsing.as.IAbsInvariant;
import ch.fhnw.cpib.parsing.as.impl.AbsInvariant;

public class Cmd31Eps implements ICmd31 {

    @Override
    public IAbsInvariant toAbsSyn() {
       return new AbsInvariant();
    }

		@Override
		public String toString(String indent) {
			return indent + "<invariant>TRUE</invariant>\n";
		}

}
