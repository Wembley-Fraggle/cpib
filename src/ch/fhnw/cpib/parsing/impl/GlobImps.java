package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IGlobImp;
import ch.fhnw.cpib.parsing.IGlobImps;
import ch.fhnw.cpib.parsing.IGlobImps1;

public class GlobImps implements IGlobImps {

    private IGlobImp globImp;
    private IGlobImps1 globImps1;

    public GlobImps(IGlobImp globImp, IGlobImps1 globImps1) {
        this.globImp = globImp;
        this.globImps1 = globImps1;
    }
}
