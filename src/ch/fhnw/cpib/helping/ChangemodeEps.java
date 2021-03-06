package ch.fhnw.cpib.helping;

import ch.fhnw.cpib.context.Modes;
import ch.fhnw.cpib.parsing.IChangemode;
import ch.fhnw.cpib.parsing.abs.IAbstSyn;

public class ChangemodeEps implements IChangemode, IAbstSyn {

	@Override
	public String toString(String indent) {
		return indent + "<ChangemodeEps/>\n";
	}

	@Override
	public Modes getMode() {
		return Modes.CONST;
	}

	@Override
	public int getLine() {
		return -1;
	}

}
