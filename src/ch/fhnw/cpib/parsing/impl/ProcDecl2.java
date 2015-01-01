package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IProcDecl2;
import ch.fhnw.cpib.parsing.IProcDecl21;

public class ProcDecl2 implements IProcDecl2 {

    private IProcDecl21 procDecl21;
    public ProcDecl2(IProcDecl21 procDecl21) {
        this.procDecl21 = procDecl21;
    }

}
