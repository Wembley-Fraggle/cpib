package ch.fhnw.cpib.parsing.impl;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import ch.fhnw.cpib.errors.GrammarError;
import ch.fhnw.cpib.lexing.ITerminal;
import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IConcSyn;
import ch.fhnw.cpib.parsing.IParser;

public class Parser implements IParser, IConcSyn{

    private static final Logger LOG = LogManager.getLogger(Parser.class);
    private List<IToken> tokenList;
    private IToken token;
    private ITerminal terminal;
    Iterator<IToken> iter;

    // private IConcSyn concSyn; // discussed later

    public Parser(List<IToken> tokenList) {
        this.tokenList = tokenList;
        iter = tokenList.iterator();
        while (iter.hasNext()) {
            token = iter.next();
            terminal = token.getType();
        }

        // FIXME concSyn = new ConcSyn(); // discussed later
    }
    
    private IToken consume(ITerminal expectedTerminal) throws GrammarError {
        return consume(expectedTerminal.getName());
    }

    private IToken consume(String expectedTerminal) throws GrammarError {
        if (terminal.getName().equals(expectedTerminal)) {
            IToken consumedToken = token;
            
            if (iter.hasNext()) {
                token = iter.next();
                // maintain class invariant
                terminal = token.getType();
            }
            return consumedToken;
        } else {
            throw new GrammarError("terminal expected: " + expectedTerminal
                    + ", terminal found: " + terminal);
        }
    }

    @Override
    public void parse() throws GrammarError {
        // TODO 
    }

    @Override
    public void program() throws GrammarError { 
       String name = terminal.getName();
       if("PROGRAM".equals(name)) {
           LOG.debug("program ::= PROGRAM IDENT progParamList program1 program2 program3 DO cpsCmd program4 ENDPROGRAM");
           consume(terminal);
           consume("IDENT");
           progParamList();
           program1();
           program2();
           program3();
           consume("DO");
           cpsCmd();
           program4();
           consume("ENDPROGRAM");
       }
       else {
           handleInvalidToken();
       }
    }


    @Override
    public void program1() throws GrammarError {
        String name = terminal.getName();
        if("INV".equals(name)) {
            LOG.debug("program1 ::= invariant");
            invariant();
        }
        else if("DO".equals(name)) {
            LOG.debug("program1 ::= <e>");
        }
        else if("PRE".equals(name)) {
            LOG.debug("program1 ::= <e>");
        }
        else if("GLOBAL".equals(name)) {
            LOG.debug("program1 ::= <e>");
        }
        else {
            handleInvalidToken();
        }
        
    }

    @Override
    public void program2() throws GrammarError {
        String name = terminal.getName();
        if("GLOBAL".equals(name)) {
            LOG.debug("program2 ::= program21");
            consume(terminal);
            program21();
        }
        else if("DO".equals(name)) {
            LOG.debug("program2 ::= <e>");
        }
        else if("PRE".equals(name)) {
            LOG.debug("program2 ::= <e>");
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void program21() throws GrammarError {
        String name = terminal.getName();
        if("GLOBAL".equals(name)) {
            LOG.debug("program21 ::= GLOBAL cpsDecl");
            consume(terminal);
            cpsDecl();
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void program3() throws GrammarError {
        String name = terminal.getName();
        if("PRE".equals(name)) {
            LOG.debug("program3 ::= precondition");
            consume(terminal);
            precondition();
        }
        else if("DO".equals(name)) {
            LOG.debug("program3 ::= <e>");
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void program4() throws GrammarError {
        String name = terminal.getName();
        if("POST".equals(name)) {
            LOG.debug("program4 ::= precondition");
            consume(terminal);
            precondition();
        }
        else if("ENDPROGRAM".equals(name)) {
            LOG.debug("program4 ::= <e>");
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void progParamList() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void cpsCmd() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void cpsDecl() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void stoDecl() throws GrammarError {
        String name = terminal.getName();
        if("IDENT".equals(name)) {
            LOG.debug("stoDecl ::= stoDecl1 typedIdent");
            consume(terminal);
            stoDecl1();
            typedIdent();
        }
        else if("VAR".equals(name)) {
            LOG.debug("stoDecl ::= stoDecl1 typedIdent");
            consume(terminal);
            stoDecl1();
            typedIdent();
        }
        else if("CONST".equals(name)) {
            LOG.debug("stoDecl ::= stoDecl1 typedIdent");
            consume(terminal);
            stoDecl1();
            typedIdent();
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void stoDecl1() throws GrammarError {
        String name = terminal.getName();
        if("VAR".equals(name)) {
            LOG.debug("stoDecl1 ::= changemode");
            consume(terminal);
            changemode();
        }
        else if("CONST".equals(name)) {
            LOG.debug("stoDecl1 ::= changemode");
            consume(terminal);
            changemode();
        }
        else if("IDENT".equals(name)) {
            LOG.debug("stoDecl1 ::= <e>");
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void funDecl() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void funDecl1() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void funDecl11() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void funDecl2() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void funDecl21() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void funDecl3() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void funDecl31() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void funDecl4() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void funDecl41() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void funDecl5() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void funDecl51() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void procDecl() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void typedIdent() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void changemode() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void paramList() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void globImps() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void cpsStoDecl() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void procDecl1() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void procDecl11() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void procDecl2() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void procDecl21() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void procDecl3() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void procDecl4() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void globImp() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void globImps1() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void globImps2() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void globImp1() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void globImp2() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void flowmode() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void decl() throws GrammarError {
        String name = terminal.getName();
        if("IDENT".equals(name)) {
            LOG.debug("decl ::= stoDecl");
            consume(terminal);
            stoDecl();
        }
        else if("VAR".equals(name)) {
            LOG.debug("decl ::= stoDecl");
            consume(terminal);
            stoDecl();
        }
        else if("CONST".equals(name)) {
            LOG.debug("decl ::= stoDecl");
            consume(terminal);
            stoDecl();
        }
        else if("FUN".equals(name)) {
            LOG.debug("decl ::= funDecl");
            consume(terminal);
            funDecl();
        }
        else if("PROC".equals(name)) {
            LOG.debug("decl ::= procDecl");
        }
        else {
            handleInvalidToken();
        }

    }

    @Override
    public void cpsDecl1() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void cpsDecl2() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void cpsStoDecl1() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void cpsStoDecl2() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void progParamList1() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void progParamList2() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void progParam() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void progParamList3() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void progParamList4() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void progParam1() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void progParam2() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void paramList1() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void paramList2() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void paramList3() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void param() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void paramList4() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void param1() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void param2() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void param3() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mechmode() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void atomtype() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void expr() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void exprList() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void cmd41() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void globInits() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void cpsCmd1() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void cpsCmd2() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void cmd() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void idents() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void idents1() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void idents2() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void term1() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void expr1() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void expr2() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void boolopr() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void term2() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void term12() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void term11() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void relopr() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void term3() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void term21() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void term211() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void addopr() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void term31() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void term311() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void multopr() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void factor() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void factor1() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void factor2() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void factor21() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void factor211() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void factor3() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void factor4() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void factor5() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void monadicOpr() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void exprList1() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void exprList2() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void exprList3() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void exprList4() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void boolval() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void cmd1() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void cmd2() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void cmd3() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void cmd31() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void cmd4() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void cmd5() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void cmd6() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void cmd7() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void literal() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void precondition() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void postcondition() throws GrammarError {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void invariant() throws GrammarError {
        // TODO Auto-generated method stub
        
    }
    
    private void handleInvalidToken() throws GrammarError {
        throw new GrammarError("Unexpected token "+token.getType().getName()+" at position"+token.getStart());
    }

}
