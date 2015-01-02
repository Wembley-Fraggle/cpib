package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IParamList;
import ch.fhnw.cpib.parsing.IParamList1;

public class ParamList implements IParamList {

    private IToken lparent;
    private IParamList1 paramList1;
    private IToken rParent;

    public ParamList(IToken lparent, IParamList1 paramList1, IToken rParent) {
        this.lparent = lparent;
        this.paramList1 = paramList1;
        this.rParent = rParent;
    }

		@Override
		public IParamList toAbsSyn() {
			return paramList1.toAbsSyn();
		}

}
