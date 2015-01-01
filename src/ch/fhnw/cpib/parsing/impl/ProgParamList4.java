package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IProgParam;
import ch.fhnw.cpib.parsing.IProgParamList4;

public class ProgParamList4 implements IProgParamList4 {

    private IToken comma;
    private IProgParam progParam;
    
    public ProgParamList4(IToken comma, IProgParam progParam) {
        this.comma = comma;
        this.progParam = progParam;
    }

}
