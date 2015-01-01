package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IProgParam;
import ch.fhnw.cpib.parsing.IProgParam1;
import ch.fhnw.cpib.parsing.IProgParam2;
import ch.fhnw.cpib.parsing.ITypedIdent;

public class ProgParam implements IProgParam {

    private IProgParam1 progParam1;
    private IProgParam2 progParam2;
    private ITypedIdent typedIdent;

    public ProgParam(IProgParam1 progParam1, IProgParam2 progParam2,
            ITypedIdent typedIdent) {
        this.progParam1 = progParam1;
        this.progParam2 = progParam2;
        this.typedIdent = this.typedIdent;
    }
}
