package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IProgParamList1;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IParam;
import ch.fhnw.cpib.parsing.abs.impl.ProgParamEps;

public class ProgParamList1Eps implements IProgParamList1 {

	@Override
	public String toString(String indent) {
		return indent + "<ProcParamList1Eps/>\n";
	}

    @Override
    public IParam toAbsSyn() {
       return new ProgParamEps();
    }

}
