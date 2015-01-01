package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IDecl;
import ch.fhnw.cpib.parsing.IProcDecl;

public class DeclProc implements IDecl {

    private IProcDecl procDecl;
    public DeclProc(IProcDecl procDecl) {
        this.procDecl = procDecl;
    }

}
