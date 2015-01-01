package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.ITerm31;
import ch.fhnw.cpib.parsing.ITerm311;

public class Term31 implements ITerm31 {

    private ITerm311 term311;
    private ITerm31 term31;

    public Term31(ITerm311 term311, ITerm31 term31) {
        this.term311 = term311;
        this.term31 = term31;
    }
}
