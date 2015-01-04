package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IProgParam;
import ch.fhnw.cpib.parsing.IProgParam1;
import ch.fhnw.cpib.parsing.IProgParam2;
import ch.fhnw.cpib.parsing.ITypedIdent;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IDecl;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IParam;

public class ProgParam implements IProgParam {

	private IProgParam1 progParam1;
	private IProgParam2 progParam2;
	private ITypedIdent typedIdent;

	public ProgParam(IProgParam1 progParam1, IProgParam2 progParam2,
			ITypedIdent typedIdent) {
		this.progParam1 = progParam1;
		this.progParam2 = progParam2;
		this.typedIdent = typedIdent;
	}

	@Override
	public String toString(String indent) {
		return indent + "<ProgParam>\n" + progParam1.toString(indent + '\t')
				+ progParam2.toString(indent + '\t')
				+ typedIdent.toString(indent + '\t') + indent + "</ProgParam>\n";
	}

    @Override
    public IParam toAbsSyn() {
        return new FunDe()
        // TODO Auto-generated method stub
        return null;
    }
}
