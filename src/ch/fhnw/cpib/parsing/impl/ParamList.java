package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IParamList;
import ch.fhnw.cpib.parsing.IParamList1;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IParam;

public class ParamList implements IParamList {

    @SuppressWarnings("unused")
		private IToken lparent;
    private IParamList1 paramList1;
    @SuppressWarnings("unused")
		private IToken rParent;

    public ParamList(IToken lparent, IParamList1 paramList1, IToken rParent) {
        this.lparent = lparent;
        this.paramList1 = paramList1;
        this.rParent = rParent;
    }

		@Override
		public IParam toAbsSyn() {
			return paramList1.toAbsSyn();
		}

		@Override
		public String toString(String indent) {
			// TODO Auto-generated method stub
			return indent
					+ "<ParamList>\n"
					+ paramList1.toString(indent + '\t')
					+ indent
					+ "</ParamList>\n";
		}

}
