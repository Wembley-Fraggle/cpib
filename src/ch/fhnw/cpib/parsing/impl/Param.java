package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IParam;
import ch.fhnw.cpib.parsing.IParam1;
import ch.fhnw.cpib.parsing.IParam2;
import ch.fhnw.cpib.parsing.IParam3;
import ch.fhnw.cpib.parsing.ITypedIdent;

public class Param implements IParam {

    private IParam1 param1;
    private IParam2 param2;
    private IParam3 param3;
    private ITypedIdent typedIdent;
    
    public Param(IParam1 param1, IParam2 param2, IParam3 param3,
            ITypedIdent typedIdent) {
        this.param1 = param1;
        this.param2 = param2;
        this.param3 = param3;
        this.typedIdent = typedIdent;
    }

		@Override
		public String toString(String indent) {
			return indent
					+ "<Param>\n"
					+ param1.toString(indent + '\t')
					+ param2.toString(indent + '\t')
					+ param3.toString(indent + '\t')
					+ typedIdent.toString(indent + '\t')
					+ indent
					+ "</Param>\n";
		}
    
}
