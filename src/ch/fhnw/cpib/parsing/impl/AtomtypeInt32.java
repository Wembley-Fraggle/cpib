package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IAtomtype;
import ch.fhnw.cpib.parsing.as.IAbsTypedIdent;

public class AtomtypeInt32 implements IAtomtype {

    IToken int32;
    public AtomtypeInt32(IToken int32) {
        this.int32 = int32;
    }
    
    public IAbsTypedIdent toAbsSyn(IAbsTypedIdent ident) {
        return ident;
    }

}
