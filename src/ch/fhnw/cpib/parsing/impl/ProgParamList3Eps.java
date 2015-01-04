package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IProgParamList3;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.ICpsDecl;
import ch.fhnw.cpib.parsing.abs.impl.CpsDeclEps;

public class ProgParamList3Eps implements IProgParamList3 {

	@Override
	public String toString(String indent) {
		return indent + "<ProgParamList3Eps/>\n";
	}

    @Override
    public ICpsDecl toAbsSyn() {
        return new CpsDeclEps();
    }

}
