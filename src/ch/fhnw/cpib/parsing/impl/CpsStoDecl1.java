package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.ICpsStoDecl1;
import ch.fhnw.cpib.parsing.ICpsStoDecl2;

public class CpsStoDecl1 implements ICpsStoDecl1 {

    private ICpsStoDecl2 cpsStoDecl2;
    private ICpsStoDecl1 cpsStoDecl1;

    public CpsStoDecl1(ICpsStoDecl2 cpsStoDecl2, ICpsStoDecl1 cpsStoDecl1) {
        this.cpsStoDecl2 = cpsStoDecl2;
        this.cpsStoDecl1 = cpsStoDecl1;
    }

}
