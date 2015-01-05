package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.ICmd31;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IDbcCmd;
import ch.fhnw.cpib.parsing.abs.impl.DbcCmdEps;

public class Cmd31Eps implements ICmd31 {
    
    @Override
    public String toString(String indent) {
        return indent + "<invariant>TRUE</invariant>\n";
    }

    @Override
    public IDbcCmd toAbsSyn() {
        return new DbcCmdEps();
    }

}
