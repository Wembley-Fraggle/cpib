package ch.fhnw.cpib.helping;

import ch.fhnw.cpib.context.Modes;
import ch.fhnw.cpib.parsing.IMechmode;
import ch.fhnw.cpib.parsing.abs.IAbstSyn;

public class MechmodeEps implements IMechmode, IAbstSyn {

	@Override
	public String toString(String indent) {
		return indent + "<MechmodeEps/>\n";
	}

	@Override
	public Modes getMode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLine() {
		return -1;
	}

}
