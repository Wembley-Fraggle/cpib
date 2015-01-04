package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IProgParamList1;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.ICpsDecl;
import ch.fhnw.cpib.parsing.abs.impl.CpsDeclEps;

public class ProgParamList1Eps implements IProgParamList1 {

	@Override
	public String toString(String indent) {
		return indent + "<ProcParamList1Eps/>\n";
	}

    @Override
    public ICpsDecl toAbsSyn() {
       return new CpsDeclEps();
    }

}
