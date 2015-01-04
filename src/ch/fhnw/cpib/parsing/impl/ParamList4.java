package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IParam;
import ch.fhnw.cpib.parsing.IParamList4;

public class ParamList4 implements IParamList4 {

    private IToken comma;
    private IParam param;
    public ParamList4(IToken comma, IParam param) {
        this.comma = comma;
        this.param = param;
    }
		@Override
		public String toString(String indent) {
			return indent + comma.getValue() + param;
		}

}
