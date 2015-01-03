package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.ICmd2;
import ch.fhnw.cpib.parsing.ICpsCmd;
import ch.fhnw.cpib.parsing.IExpr;
import ch.fhnw.cpib.parsing.as.IAbsMother.IAbsCmd;
import ch.fhnw.cpib.parsing.as.impl.AbsCondCmd;

public class Cmd2 implements ICmd2 {

    private IToken ifToken;
    private IExpr expr;
    private IToken then;
    private ICpsCmd cpsCmd;
    private IToken elseif;
    private ICpsCmd cpsCmd2;
    private IToken end;
    
    public Cmd2(IToken ifToken, IExpr expr, IToken then, ICpsCmd cpsCmd,
            IToken elseif, ICpsCmd cpsCmd2, IToken end) {
        this.ifToken = ifToken;
        this.expr = expr;
        this.then = then;
        this.cpsCmd = cpsCmd;
        this.elseif = elseif;
        this.cpsCmd2 = cpsCmd2;
        this.end = end;
    }
    
    public IAbsCmd toAbsSyn() {
        return new AbsCondCmd(expr.toAbsSyn(), cpsCmd.toAbsSyn(), cpsCmd.toAbsSyn());
    }
    
}
