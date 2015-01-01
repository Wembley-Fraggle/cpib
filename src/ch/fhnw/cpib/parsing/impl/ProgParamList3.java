package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IProgParam;
import ch.fhnw.cpib.parsing.IProgParamList3;

public class ProgParamList3 implements IProgParamList3 {

    private IProgParam progParam;
    private IProgParamList3 progParamList3;

    public ProgParamList3(IProgParam progParam, IProgParamList3 progParamList3) {
        this.progParam = progParam;
        this.progParamList3 = progParamList3;
    }

}
