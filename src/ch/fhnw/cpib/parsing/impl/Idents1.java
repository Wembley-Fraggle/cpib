package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IIdents1;
import ch.fhnw.cpib.parsing.IIdents2;

public class Idents1 implements IIdents1 {

    private IIdents2 idents2;
    private IIdents1 idents1;

    public Idents1(IIdents2 idents2, IIdents1 idents1) {
        this.idents2 = idents2;
        this.idents1 = idents1;
    }

}
