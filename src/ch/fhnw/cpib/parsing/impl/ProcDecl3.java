package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IPrecondition;
import ch.fhnw.cpib.parsing.IProcDecl3;

public class ProcDecl3 implements IProcDecl3 {

    private IPrecondition precondition;
    public ProcDecl3(IPrecondition precondition) {
        this.precondition = precondition;
    }

}
