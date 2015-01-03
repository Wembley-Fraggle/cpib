package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IProgParam;
import ch.fhnw.cpib.parsing.IProgParamList4;
import ch.fhnw.cpib.parsing.as.IAbsMother.IAbsParam;
import ch.fhnw.cpib.parsing.as.impl.AbsParam;

public class ProgParamList4 implements IProgParamList4 {

    private IToken comma;
    private IProgParam progParam;
    
    public ProgParamList4(IToken comma, IProgParam progParam) {
        this.comma = comma;
        this.progParam = progParam;
    }

		@Override
		public IAbsParam toAbsSyn() {
			// TODO Auto-generated method stub
			return new AbsParam();
		}

}
