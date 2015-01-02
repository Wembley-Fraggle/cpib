package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IBoolVal;
import ch.fhnw.cpib.parsing.as.IAbsExpr2;

public class BoolValTrue implements IBoolVal {

    private IToken boolVal;
    public BoolValTrue(IToken boolVal) {
        this.boolVal = boolVal;
    }
    
    public IAbsExpr2 toAbsSyn(IAbsExpr2 e) {
      return e;
  }

}
