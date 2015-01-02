package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.ICmd3;
import ch.fhnw.cpib.parsing.ICmd31;
import ch.fhnw.cpib.parsing.ICpsCmd;
import ch.fhnw.cpib.parsing.IExpr;

public class Cmd3 implements ICmd3 {

    private IToken whileToken;
    private IExpr expr;
    private ICmd31 cmd31;
    private IToken doToken;
    private ICpsCmd cpsCmd;
    private IToken endWhileToken;
    
    public Cmd3(IToken whileToken, IExpr expr, ICmd31 cmd31, IToken doToken,
            ICpsCmd cpsCmd, IToken endWhileToken) {
        this.whileToken = whileToken;
        this.expr = expr;
        this.cmd31 = cmd31;
        this.doToken = doToken;
        this.cpsCmd = cpsCmd;
        this.endWhileToken = endWhileToken;
    }
   
    
}