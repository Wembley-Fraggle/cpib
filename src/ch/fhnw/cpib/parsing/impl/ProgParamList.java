package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IProgParamList;
import ch.fhnw.cpib.parsing.IProgParamList1;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IParam;

public class ProgParamList implements IProgParamList {

    @SuppressWarnings("unused")
		private IToken lParent;
    private IProgParamList1 progParamList1;
    @SuppressWarnings("unused")
		private IToken rParent;
    
    public ProgParamList(IToken lParent, IProgParamList1 progParamList1,
            IToken rParent) {
        this.lParent = lParent;
        this.progParamList1 = progParamList1;
        this.rParent = rParent;
    }

    @Override
    public IParam toAbsSyn() {
        return progParamList1.toAbsSyn();
    }

    @Override
    public String toString(String indent) {
        return indent + "<ProgParamList>\n"
                + progParamList1.toString(indent + '\t')
                + indent + "</ProgParamList>\n";
    }

}
