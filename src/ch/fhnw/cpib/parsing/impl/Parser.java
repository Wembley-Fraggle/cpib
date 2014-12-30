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
            LOG.debug("program4 ::= postcondition");
            postcondition();
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
        String name = terminal.getName();
        if("LPARENT".equals(name) ) {
            LOG.debug("progParamList ::= LPARENT progParamList1 RPARENT");
            consume(terminal);
            progParamList1();
            consume("RPARENT");
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void cpsCmd() throws GrammarError {
        String name = terminal.getName();
        if("ASSERT".equals(name)
           || "DEBUGOUT".equals(name)
           || "DEBUGIN".equals(name)
           || "CALL".equals(name)
           || "WHILE".equals(name)
           || "IF".equals(name)
           || "LPARENT".equals(name)
           || "OLD".equals(name)
           || "MINUS".equals(name)
           || "PLUS".equals(name)
           || "IDENT".equals(name)
           || "TRUE".equals(name)
           || "FALSE".equals(name)
           || "SKIP".equals(name)) {
            LOG.debug("cpsCmd ::= cmd cpsCmd1");
            cmd();
            cpsCmd1();
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void cpsDecl() throws GrammarError {
        String name = terminal.getName();
        if("PROC".equals(name) || "FUN".equals(name) || "IDENT".equals(name)
           || "VAR".equals(name) || "CONST".equals(name) ) {
            LOG.debug("cpsDecl ::= decl cpsDecl1");
            decl();
            cpsDecl1();
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void stoDecl() throws GrammarError {
        String name = terminal.getName();
        if("IDENT".equals(name)) {
            LOG.debug("stoDecl ::= stoDecl1 typedIdent");
            stoDecl1();
            typedIdent();
        }
        else if("VAR".equals(name)) {
            LOG.debug("stoDecl ::= stoDecl1 typedIdent");
            stoDecl1();
            typedIdent();
        }
        else if("CONST".equals(name)) {
            LOG.debug("stoDecl ::= stoDecl1 typedIdent");
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
            changemode();
        }
        else if("CONST".equals(name)) {
            LOG.debug("stoDecl1 ::= changemode");
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
        String name = terminal.getName();
        if("FUN".equals(name)) {
            LOG.debug("funDecl ::= FUN IDENT paramList RETURNS stoDecl funDecl1 funDecl2 funDecl3 DO cpsCmd funDecl4 ENDFUN");
            consume(terminal);
            consume("IDENT");
            paramList();
            consume("RETURNS");
            stoDecl();
            funDecl1();
            funDecl2();
            funDecl3();
            consume("DO");
            cpsCmd();
            funDecl4();
            consume("ENDFUN");
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void funDecl1() throws GrammarError {
        String name = terminal.getName();
        if("GLOBAL".equals(name)) {
            LOG.debug("funDecl1 ::= funDecl11");
            funDecl11();
        }
        else if("DO".equals(name)) {
            LOG.debug("funDecl1 ::= <e>");
        }
        else if("PRE".equals(name)) {
            LOG.debug("funDecl1 ::= <e>");
        }
        else if("LOCAL".equals(name)) {
            LOG.debug("funDecl1 ::= <e>");
        }
        else {
            handleInvalidToken();
        }
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
        String name = terminal.getName();
        if("POST".equals(name)) {
            LOG.debug("funDecl4 ::= postcondition");
            postcondition();
        }
        else if("ENDFUN".equals(name)) {
            LOG.debug("funDecl4 ::= <e>");
        }
        else {
            handleInvalidToken();
        }
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
        String name = terminal.getName();
        if("PROC".equals(name)) {
            LOG.debug("procDecl ::= PROC IDENT paramList procDecl1 procDecl2 procDecl3 DO cpsCmd procDecl4 ENDPROC");
            consume(terminal);
            consume("IDENT");
            paramList();
            procDecl1();
            procDecl2();
            procDecl3();
            consume("DO");
            cpsCmd();
            procDecl4();
            consume("ENDPROC");
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void typedIdent() throws GrammarError {
        String name = terminal.getName();
        if("IDENT".equals(name)) {
            LOG.debug("typedIdent ::= IDENT COLON atomtype");
            consume(terminal);
            consume("COLON");
            atomtype();
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void changemode() throws GrammarError {
        String name = terminal.getName();
        if("CONST".equals(name)) {
            LOG.debug("changemode ::= CONST");
            consume(terminal);
        } else if("VAR".equals(name)) {
            LOG.debug("changemode ::= VAR");
            consume(terminal);
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void paramList() throws GrammarError {
        String name = terminal.getName();
        if("LPARENT".equals(name)) {
            LOG.debug("paramList1 ::= LPARENT paramList1 RPARENT");
            consume(terminal);
            paramList1();
            consume("RPARENT");
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void globImps() throws GrammarError {
        String name = terminal.getName();
        if("IDENT".equals(name) || "VAR".equals(name) || "CONST".equals(name)
           || "OUT".equals(name) || "INOUT".equals(name) || "IN".equals(name)) {
            LOG.debug("globImps ::= globImp globImps1");
            globImp();
            globImps1();
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void cpsStoDecl() throws GrammarError {
        String name = terminal.getName();
        if("IDENT".equals(name) || "VAR".equals(name) || "CONST".equals(name)) {
            LOG.debug("cpsStoDecl ::= stoDecl cpsStoDecl1");
            consume(terminal);
            stoDecl();
            cpsStoDecl1();
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void procDecl1() throws GrammarError {
        String name = terminal.getName();
        if("GLOBAL".equals(name)) {
            LOG.debug("procDecl1 ::= procDecl11");
            procDecl11();
        }
        else if("DO".equals(name)) {
            LOG.debug("procDecl1 ::= <e>");
        }
        else if("DO".equals(name)) {
            LOG.debug("procDecl1 ::= <e>");
        }
        else if("LOCAL".equals(name)) {
            LOG.debug("procDecl1 ::= <e>");
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void procDecl11() throws GrammarError {
        String name = terminal.getName();
        if("GLOBAL".equals(name)) {
            LOG.debug("procDecl11 ::= globImps");
            globImps();
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void procDecl2() throws GrammarError {
        String name = terminal.getName();
        if("LOCAL".equals(name)) {
            LOG.debug("procDecl2 ::= procDecl21");
            procDecl21();
        }
        else if("DO".equals(name)) {
            LOG.debug("procDecl2 ::= <e>");
        }
        else if("PRE".equals(name)) {
            LOG.debug("procDecl2 ::= <e>");
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void procDecl21() throws GrammarError {
        String name = terminal.getName();
        if("LOCAL".equals(name)) {
            LOG.debug("procDecl21 ::= cpsStoDecl");
            cpsStoDecl();
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void procDecl3() throws GrammarError {
        String name = terminal.getName();
        if("PRE".equals(name)) {
            LOG.debug("procDecl3 ::= precondition");
            precondition();
        }
        else if("DO".equals(name)) {
            LOG.debug("procDecl3 ::= <e>");
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void procDecl4() throws GrammarError {
        String name = terminal.getName();
        if("POST".equals(name)) {
            LOG.debug("procDecl4 ::= postcondition");
            postcondition();
        }
        else if("ENDPROC".equals(name)) {
            LOG.debug("procDecl4 ::= <e>");
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void globImp() throws GrammarError {
        String name = terminal.getName();
        if("IDENT".equals(name) || "VAR".equals(name) || "CONST".equals(name)
           || "OUT".equals(name) || "INOUT".equals(name) || "IN".equals(name)) {
            LOG.debug("globImp ::= globImp1 globImp2 IDENT");
            globImp1();
            globImp2();
            consume("IDENT");
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void globImps1() throws GrammarError {
        String name = terminal.getName();
        if("COMMA".equals(name)) {
            LOG.debug("globImps1 ::= globImps2 globImps1");
            globImps2();
            globImps1();
        }
        else if("DO".equals(name)) {
            LOG.debug("globImps1 ::= <e>");
        }
        else if("PRE".equals(name)) {
            LOG.debug("globImps1 ::= <e>");
        }
        else if("LOCAL".equals(name)) {
            LOG.debug("globImps1 ::= <e>");
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void globImps2() throws GrammarError {
        String name = terminal.getName();
        if("COMMA".equals(name)) {
            LOG.debug("globImps2 ::= globImp");
            globImp();
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void globImp1() throws GrammarError {
        String name = terminal.getName();
        if("OUT".equals(name) || "INOUT".equals(name) || "IN".equals(name)) {
            LOG.debug("globImp1 ::= flowmode");
            flowmode();
        }
        else if("IDENT".equals("IDENT")) {
            LOG.debug("globImp1 ::= <e>");
        }
        else if("VAR".equals("IDENT")) {
            LOG.debug("globImp1 ::= <e>");
        }
        else if("CONST".equals("IDENT")) {
            LOG.debug("globImp1 ::= <e>");
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void globImp2() throws GrammarError {
        String name = terminal.getName();
        if("VAR".equals(name) || "CONST".equals(name)) {
            LOG.debug("globImp2 ::= changemode");
            changemode();
        }
        if("IDENT".equals(name)) {
            LOG.debug("globImp2 ::= <e>");
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void flowmode() throws GrammarError {
        String name = terminal.getName();
        if("IN".equals(name)) {
            LOG.debug("flowmode ::= IN");
            consume(terminal);
        } else if("INOUT".equals(name)) {
            LOG.debug("flowmode ::= INOUT");
            consume(terminal);
        } else if("OUT".equals(name)) {
            LOG.debug("flowmode ::= OUT");
            consume(terminal);
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void decl() throws GrammarError {
        String name = terminal.getName();
        if("IDENT".equals(name) || "VAR".equals(name) || "CONST".equals(name)) {
            LOG.debug("decl ::= stoDecl");
            stoDecl();
        }
        else if("FUN".equals(name)) {
            LOG.debug("decl ::= funDecl");
            funDecl();
        }
        else if("PROC".equals(name)) {
            LOG.debug("decl ::= procDecl");
            procDecl();
        }
        else {
            handleInvalidToken();
        }

    }

    @Override
    public void cpsDecl1() throws GrammarError {
        String name = terminal.getName();
        if("SEMI".equals(name)) {
            LOG.debug("cpsDecl1 ::= cpsDecl2 cpsDecl1");
            cpsDecl2();
            cpsDecl1();
        }
        else if("DO".equals(name)) {
            LOG.debug("cpsDecl1 ::= <e>");
        }
        else if("PRE".equals(name)) {
            LOG.debug("cpsDecl1 ::= <e>");
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void cpsDecl2() throws GrammarError {
        String name = terminal.getName();
        if("SEMI".equals(name)) {
            LOG.debug("cpsDecl2 ::= decl");
            decl();
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void cpsStoDecl1() throws GrammarError {
        String name = terminal.getName();
        if("SEMI".equals(name)) {
            LOG.debug("cpsStoDecl1 ::= cpsStoDecl2 cpsStoDecl1");
            cpsStoDecl2();
            cpsStoDecl1();
        }
        else if("DO".equals(name)) {
            LOG.debug("cpsStoDecl1 ::= <e>");
        }
        else if("PRE".equals(name)) {
            LOG.debug("cpsStoDecl1 ::= <e>");
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void cpsStoDecl2() throws GrammarError {
        String name = terminal.getName();
        if("SEMI".equals(name)) {
            LOG.debug("cpsStoDecl2 ::= SEMI stoDecl");
            consume(terminal);
            stoDecl();
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void progParamList1() throws GrammarError {
        String name = terminal.getName();
        if("IDENT".equals(name)
           || "VAR".equals(name) || "CONST".equals(name)
           || "OUT".equals(name) || "INOUT".equals(name) || "IN".equals(name)) {
            LOG.debug("progParamList1 ::= progParamList2");
            progParamList2();
        }
        else if("RPARENT".equals(name)) {
            LOG.debug("progParamList1 ::= <e>");
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void progParamList2() throws GrammarError {
        String name = terminal.getName();
        if("IDENT".equals(name)
           || "VAR".equals(name) || "CONST".equals(name)
           || "OUT".equals(name) || "INOUT".equals(name) || "IN".equals(name)) {
            LOG.debug("progParamList2 ::= progParam progParamList3");
            progParam();
            progParamList3();
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void progParam() throws GrammarError {
        String name = terminal.getName();
        if("IDENT".equals(name)
           || "VAR".equals(name) || "CONST".equals(name)
           || "OUT".equals(name) || "INOUT".equals(name) || "IN".equals(name)) {
            LOG.debug("progParam ::= progParam1 progParam2 typedIdent");
            progParam1();
            progParam2();
            typedIdent();
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void progParamList3() throws GrammarError {
        String name = terminal.getName();
        if("COMMA".equals(name)
           || "VAR".equals(name) || "CONST".equals(name)
           || "OUT".equals(name) || "INOUT".equals(name) || "IN".equals(name)) {
            LOG.debug("progParamList3 ::= progParamList4 progParamList3");
            progParam();
            progParamList3();
        }
        else if("RPARENT".equals(name)) {
            LOG.debug("progParamList3 ::= <e>");
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void progParamList4() throws GrammarError {
        String name = terminal.getName();
        if("COMMA".equals(name)) {
            LOG.debug("progParamList4 ::= COMMA progParam");
            consume(terminal);
            progParam();
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void progParam1() throws GrammarError {
        String name = terminal.getName();
        if("OUT".equals(name) || "INOUT".equals(name) || "IN".equals(name)) {
            LOG.debug("progParam1 ::= flowmode");
            flowmode();
        }
        else  if("IDENT".equals(name)) {
            LOG.debug("progParam1 ::= <e>");
        }
        else  if("VAR".equals(name)) {
            LOG.debug("progParam1 ::= <e>");
        }
        else  if("CONST".equals(name)) {
            LOG.debug("progParam1 ::= <e>");
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void progParam2() throws GrammarError {
        String name = terminal.getName();
        if("VAR".equals(name) || "CONST".equals(name) ) {
            LOG.debug("progParam2 ::= changemode");
            changemode();
        }
        else  if("IDENT".equals(name)) {
            LOG.debug("progParam2 ::= <e>");
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void paramList1() throws GrammarError {
        String name = terminal.getName();
        if("IDENT".equals(name)
                || "VAR".equals(name) || "CONST".equals(name)
                || "REF".equals(name) || "COPY".equals(name)
                || "OUT".equals(name) || "INOUT".equals(name) || "IN".equals(name)) {
            LOG.debug("paramList1 ::= paramList2");
            paramList2();
        }
        else  if("RPARENT".equals(name)) {
            LOG.debug("paramList1 ::= <e>");
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void paramList2() throws GrammarError {
        String name = terminal.getName();
        if("IDENT".equals(name)
            || "VAR".equals(name) || "CONST".equals(name)
            || "REF".equals(name) || "COPY".equals(name)
            || "OUT".equals(name) || "INOUT".equals(name) || "IN".equals(name)) {
            LOG.debug("paramList2 ::= param paramList3");
            param();
            paramList3();
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void paramList3() throws GrammarError {
        String name = terminal.getName();
        if("COMMA".equals(name)) {
            LOG.debug("paramList3 ::= paramList4 paramList3");
            paramList4();
            paramList3();
        }
        else if("RPARENT".equals(name)) {
            LOG.debug("paramList3 ::= <e>");
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void param() throws GrammarError {
        String name = terminal.getName();
        if("IDENT".equals(name)
                || "VAR".equals(name) || "CONST".equals(name)
                || "REF".equals(name) || "COPY".equals(name)
                || "OUT".equals(name) || "INOUT".equals(name) || "IN".equals(name)) {
            LOG.debug("param ::= param1 param2 param3 typedIdent");
            param1();
            param2();
            param3();
            typedIdent();
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void paramList4() throws GrammarError {
        String name = terminal.getName();
        if("COMMA".equals(name)) {
            LOG.debug("paramList4 ::= COMMA param");
            consume(terminal);
            param();
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void param1() throws GrammarError {
        String name = terminal.getName();
        if("OUT".equals(name) || "INOUT".equals(name) || "IN".equals(name)) {
            LOG.debug("param1 ::= flowmode");
            flowmode();
        } else if("IDENT".equals(name)
            || "VAR".equals(name) || "CONST".equals(name)
            || "REF".equals(name) || "COPY".equals(name)) {
            LOG.debug("param1 ::= <e>");
        }
        else {
            handleInvalidToken();
        }  
    }

    @Override
    public void param2() throws GrammarError {
        String name = terminal.getName();
        if("REF".equals(name) || "COPY".equals(name) ) {
            LOG.debug("param2 ::= mechmode");
            mechmode();
        } else if("IDENT".equals(name)
            || "VAR".equals(name) || "CONST".equals(name)) {
            LOG.debug("param2 ::= <e>");
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void param3() throws GrammarError {
        String name = terminal.getName();
        if("VAR".equals(name) || "CONST".equals(name)) {
            LOG.debug("param3 ::= changemode");
            changemode();
        } else if("IDENT".equals(name)) {
            LOG.debug("param3 ::= <e>");
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void mechmode() throws GrammarError {
        String name = terminal.getName();
        if("COPY".equals(name)) {
            LOG.debug("mechmode ::= COPY");
            consume(terminal);
        } else if("REF".equals(name)) {
            LOG.debug("mechmode ::= REF");
            consume(terminal);
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void atomtype() throws GrammarError {
        String name = terminal.getName();
        if("BOOL".equals(name)) {
            LOG.debug("atomtype ::= BOOL");
           consume(terminal);
        } else if("INT32".equals(name)) {
            LOG.debug("atomtype ::= INT32");
            consume(terminal);
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void expr() throws GrammarError {
        String name = terminal.getName();
        if("LPARENT".equals(name)
           || "OLD".equals(name)
           || "MINUS".equals(name)
           || "PLUS".equals(name)
           || "NOT".equals(name)
           || "IDENT".equals(name)
           || "INTVAL32".equals(name)
           || "TRUE".equals(name)
           || "FALSE".equals(name)) {
            LOG.debug("expr ::= term1 expr1");
            term1();
            expr1();
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void exprList() throws GrammarError {
        String name = terminal.getName();
        if("LPARENT".equals(name)) {
            LOG.debug("exprList ::= LPARENT exprList1 RPARENT");
            consume(terminal);
            exprList1();
            consume("RPARENT");
        } else {
            handleInvalidToken();
        }
    }

    @Override
    public void cmd41() throws GrammarError {
        String name = terminal.getName();
        if("INIT".equals(name) || "CONST".equals(name)) {
            LOG.debug("cmd41 ::= globInits");
            globInits();
        } else if("ENDWHILE".equals(name)
                || "ENDIF".equals(name)
                || "ELSE".equals(name)
                || "ENDPROC".equals(name)
                || "ENDFUN".equals(name)
                || "ENDPROGRAM".equals(name)
                || "POST".equals(name)
                || "SEMI".equals(name)) {
            LOG.debug("cmd41 ::= <e>");
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void globInits() throws GrammarError {
        String name = terminal.getName();
        if("INIT".equals(name)) {
            LOG.debug("globInits ::= INIT idents");
            consume(terminal);
            idents();
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void cpsCmd1() throws GrammarError {
        String name = terminal.getName();
        if("SEMI".equals(name)) {
            LOG.debug("cpsCmd1 ::= cpsCmd2 cpsCmd1");
            cpsCmd2();
            cpsCmd1();
        }
        else if(
                "ENDWHILE".equals(name)
                || "ENDIF".equals(name)
                || "ELSE".equals(name)
                || "ENDPROC".equals(name)
                || "ENDFUN".equals(name)
                || "ENDPROGRAM".equals(name)
                || "POST".equals(name)) {
            LOG.debug("cpsCmd1 ::= <e>");
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void cpsCmd2() throws GrammarError {
        String name = terminal.getName();
        if("SEMI".equals(name)) {
            LOG.debug("cpsCmd2 ::= SEMI cmd");
            consume(terminal);
            cmd();
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void cmd() throws GrammarError {
        String name = terminal.getName();
        if("SKIP".equals(name) ) {
            LOG.debug("cmd ::= SKIP");
            consume(terminal);
        } else if("LPARENT".equals(name) 
                || "IDENT".equals(name)
                || "INTVAL32".equals(name)
                || "TRUE".equals(name) || "FALSE".equals(name)
                || "MINUS".equals(name) || "PLUS".equals(name)
                || "NOT".equals(name)
                || "OLD".equals(name)) {
            LOG.debug("cmd ::= <cmd1>");
            cmd1();
        }
        else if("IF".equals(name)) {
            LOG.debug("cmd ::= <cmd2>");
            cmd2();
        }
        else if("WHILE".equals(name)) {
            LOG.debug("cmd ::= <cmd3>");
            cmd3();
        }
        else if("CALL".equals(name)) {
            LOG.debug("cmd ::= <cmd4>");
            cmd4();
        }
        else if("DEBUGIN".equals(name)) {
            LOG.debug("cmd ::= <cmd5>");
            cmd5();
        }
        else if("DEBUGOUT".equals(name)) {
            LOG.debug("cmd ::= <cmd6>");
            cmd6();
        }
        else if("ASSERT".equals(name)) {
            LOG.debug("cmd ::= <cmd7>");
            cmd7();
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void idents() throws GrammarError {
        String name = terminal.getName();
        if("IDENT".equals(name) ) {
            LOG.debug("idents ::= IDENT idents1");
            consume(terminal);
            idents1();
        } else {
            handleInvalidToken();
        }
    }

    @Override
    public void idents1() throws GrammarError {
        String name = terminal.getName();
        if("COMMA".equals(name) ) {
            LOG.debug("idents1 ::= idents2 idents1");
            idents2();
            idents1();
        } else if("ENDWHILE".equals(name)
                || "ENDIF".equals(name)
                || "ELSE".equals(name)
                || "ENDPROC".equals(name)
                || "ENDFUN".equals(name)
                || "ENDPROGRAM".equals(name)
                || "POST".equals(name)
                || "SEMI".equals(name)){
            LOG.debug("idents1 ::= <e>");
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void idents2() throws GrammarError {
        String name = terminal.getName();
        if("COMMA".equals(name) ) {
            LOG.debug("idents2 ::= COMMA IDENT");
            consume(terminal);
            consume("IDENT");
        } 
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void term1() throws GrammarError {
        String name = terminal.getName();
        if("LPARENT".equals(name)
                || "OLD".equals(name)
                || "MINUS".equals(name)
                || "PLUS".equals(name)
                || "NOT".equals(name)
                || "IDENT".equals(name)
                || "INTVAL32".equals(name)
                || "TRUE".equals(name)
                || "FALSE".equals(name)) {
            LOG.debug("term1 ::= term2 term11");
            term2();
            term11();
        } else {
            handleInvalidToken();
        }
    }

    @Override
    public void expr1() throws GrammarError {
        String name = terminal.getName();
        if("COR".equals(name)
           || "CAND".equals(name)
           || "OR".equals(name)
           || "AND".equals(name)) {
            LOG.debug("expr1 ::= expr2 expr1");
            expr2();
            expr1();
        } else if("PRE".equals(name)
                || "GLOBAL".equals(name)
                || "COMMA".equals(name)
                || "RPARENT".equals(name)
                || "DO".equals(name)
                || "INV".equals(name)
                || "THEN".equals(name)
                || "ENDWHILE".equals(name)
                || "ENDIF".equals(name)
                || "ELSE".equals(name)
                || "ENDPROC".equals(name)
                || "ENDFUN".equals(name)
                || "ENDPROGRAM".equals(name)
                || "POST".equals(name)
                || "SEMI".equals(name)
                || "BECOMES".equals(name)) {
            LOG.debug("expr1 ::= <e>");
        } else {
            handleInvalidToken();
        }
    }

    @Override
    public void expr2() throws GrammarError {
        String name = terminal.getName();
        if("COR".equals(name)
            || "CAND".equals(name)
            || "OR".equals(name)
            || "AND".equals(name)) {
             LOG.debug("expr2 ::= boolopr term1");
             boolopr();
             term1();
         } else {
             handleInvalidToken();
         }
    }

    @Override
    public void boolopr() throws GrammarError {
        String name = terminal.getName();
        if("AND".equals(name)) { 
            LOG.debug("boolopr ::= AND");
            consume(terminal);
        } 
        else if("OR".equals(name)) { 
            LOG.debug("relopr ::= OR");
            consume(terminal);
        }
        else if("CAND".equals(name)) { 
            LOG.debug("relopr ::= CAND");
            consume(terminal);
        }
        if("COR".equals(name)) { 
            LOG.debug("relopr ::= COR");
            consume(terminal);
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void term2() throws GrammarError {
        String name = terminal.getName();
        if("LPARENT".equals(name)
            || "OLD".equals(name)
            || "MINUS".equals(name)
            || "PLUS".equals(name)
            || "NOT".equals(name)
            || "IDENT".equals(name)
            || "INTVAL32".equals(name)
            || "TRUE".equals(name)
            || "FALSE".equals(name)) {
            LOG.debug("term2 ::= term3 term21");
            term3();
            term21();
        }
        else {
            handleInvalidToken();
        }
        
    }

    @Override
    public void term12() throws GrammarError {
        String name = terminal.getName();
        if("GT".equals(name)
            || "LT".equals(name)
            || "NE".equals(name)
            || "EQ".equals(name)) {
            LOG.debug("term12 ::= relopr term2");
            relopr();
            term2();
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void term11() throws GrammarError {
        String name = terminal.getName();
        if("GT".equals(name)
            || "LT".equals(name)
            || "NE".equals(name)
            || "EQ".equals(name)) {
             LOG.debug("term11 ::= term12");
             term12();
        } else if("PRE".equals(name)
            || "GLOBAL".equals(name)
            || "COMMA".equals(name)
            || "RPARENT".equals(name)
            || "DO".equals(name)
            || "INV".equals(name)
            || "THEN".equals(name)
            || "ENDWHILE".equals(name)
            || "ENDIF".equals(name)
            || "ELSE".equals(name)
            || "ENDPROC".equals(name)
            || "ENDFUN".equals(name)
            || "ENDPROGRAM".equals(name)
            || "POST".equals(name)
            || "SEMI".equals(name)
            || "BECOMES".equals(name)
            || "COR".equals(name)
            || "CAND".equals(name)
            || "OR".equals(name)
            || "AND".equals(name)) {
            LOG.debug("term11 ::= <e>");
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void relopr() throws GrammarError {
        String name = terminal.getName();
        if("EQ".equals(name)) { 
            LOG.debug("relopr ::= EQ");
            consume(terminal);
        } 
        else if("NE".equals(name)) { 
            LOG.debug("relopr ::= NE");
            consume(terminal);
        }
        else if("LT".equals(name)) { 
            LOG.debug("relopr ::= LT");
            consume(terminal);
        }
        if("GT".equals(name)) { 
            LOG.debug("relopr ::= GT");
            consume(terminal);
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void term3() throws GrammarError {
        String name = terminal.getName();
        if("LPARENT".equals(name) 
            || "OLD".equals(name)
            || "MINUS".equals(name)
            || "PLUS".equals(name)
            || "NOT".equals(name)
            || "IDENT".equals(name)
            || "INTVAL32".equals(name)
            || "TRUE".equals(name)
            || "FALSE".equals(name)) {
            LOG.debug("term3 ::= factor term31");
            factor();
            term31();
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void term21() throws GrammarError {
        String name = terminal.getName();
        if("MINUS".equals(name)
           || "PLUS".equals(name)) {
            LOG.debug("term21 ::= term211 term21");
            term211();
            term21();
        }
        else if("PRE".equals(name)
        || "GLOBAL".equals(name)
        || "COMMA".equals(name)
        || "RPARENT".equals(name)
        || "DO".equals(name)
        || "INV".equals(name)
        || "THEN".equals(name)
        || "ENDWHILE".equals(name)
        || "ENDIF".equals(name)
        || "ELSE".equals(name)
        || "ENDPROC".equals(name)
        || "ENDFUN".equals(name)
        || "ENDPROGRAM".equals(name)
        || "POST".equals(name)
        || "SEMI".equals(name)
        || "BECOMES".equals(name)
        || "COR".equals(name)
        || "CAND".equals(name)
        || "OR".equals(name)
        || "AND".equals(name)
        || "GT".equals(name)
        || "LT".equals(name)
        || "NE".equals(name)
        || "EQ".equals(name)) {
            LOG.debug("term21 ::= <e>");
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void term211() throws GrammarError {
        String name = terminal.getName();
        if("MINUS".equals(name)
           || "PLUS".equals(name)) { 
            LOG.debug("term211 ::= addopr term3");
            addopr();
            term3();
        } else {
            handleInvalidToken();
        }
    }

    @Override
    public void addopr() throws GrammarError {
        String name = terminal.getName();
        if("PLUS".equals(name)) { 
            LOG.debug("addopr ::= PLUS");
            consume(terminal);
        } 
        else if("MINUS".equals(name)) { 
            LOG.debug("addopr ::= MINUS");
            consume(terminal);
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void term31() throws GrammarError {
        String name = terminal.getName();
        if("MOD".equals(name)
           || "DIV".equals(name)
           || "TIMES".equals(name)
           ) {
            LOG.debug("term31 ::= term311 term31");
            term311();
            term31();
        }
        else if("PRE".equals(name)
        || "GLOBAL".equals(name)
        || "COMMA".equals(name)
        || "RPARENT".equals(name)
        || "DO".equals(name)
        || "INV".equals(name)
        || "THEN".equals(name)
        || "ENDWHILE".equals(name)
        || "ENDIF".equals(name)
        || "ELSE".equals(name)
        || "ENDPROC".equals(name)
        || "ENDFUN".equals(name)
        || "ENDPROGRAM".equals(name)
        || "POST".equals(name)
        || "SEMI".equals(name)
        || "BECOMES".equals(name)
        || "COR".equals(name)
        || "CAND".equals(name)
        || "OR".equals(name)
        || "AND".equals(name)
        || "GT".equals(name)
        || "LT".equals(name)
        || "NE".equals(name)
        || "EQ".equals(name)
        || "MINUS".equals(name)
        || "PLUS".equals(name)) {
            LOG.debug("term31 ::= <e>");
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void term311() throws GrammarError {
        String name = terminal.getName();
        if("MOD".equals(name)
            || "DIV".equals(name)
            || "TIMES".equals(name)) {
            LOG.debug("term311 ::= multopr factor");
            multopr();
            factor();
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void multopr() throws GrammarError {
        String name = terminal.getName();
        if("TIMES".equals(name)) { 
            LOG.debug("multopr ::= TIMES");
            consume(terminal);
        } 
        else if("DIV".equals(name)) { 
            LOG.debug("multopr ::= DIV");
            consume(terminal);
        }
        else if("MOD".equals(name)) { 
            LOG.debug("multopr ::= MOD");
            consume(terminal);
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void factor() throws GrammarError {
        String name = terminal.getName();
        if("INTVAL32".equals(name)
            || "TRUE".equals(name)
            || "FALSE".equals(name)) {
            LOG.debug("factor ::= factor1");
            factor1();
        } else if("IDENT".equals(name)) {
                LOG.debug("factor ::= factor2");
                factor2();
        } else if("MINUS".equals(name)
                || "PLUS".equals(name)
                || "NOT".equals(name)) {
            LOG.debug("factor ::= factor3");
            factor3();
        } else if("OLD".equals(name)) {
            LOG.debug("factor ::= factor4");
            factor4();
        } else if("LPARENT".equals(name)) {
            LOG.debug("factor ::= factor5");
            factor5();
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void factor1() throws GrammarError {
        String name = terminal.getName();
        if("INTVAL32".equals(name)
            || "TRUE".equals(name)
            || "FALSE".equals(name)) {
            LOG.debug("factor1 ::= literal");
            literal();
        } else {
            handleInvalidToken();
        }
    }

    @Override
    public void factor2() throws GrammarError {
        String name = terminal.getName();
        if("IDENT".equals(name)) {
            LOG.debug("factor2 ::= IDENT factor21");
            consume(terminal);
            factor21();
        } else {
            handleInvalidToken();
        }
    }

    @Override
    public void factor21() throws GrammarError {
        String name = terminal.getName();
        if("LPARENT".equals(name)
            || "INIT".equals(name)) {
            LOG.debug("factor21 ::= factor211");
            factor211();
        } else if("PRE".equals(name)
              || "GLOBAL".equals(name)
              || "COMMA".equals(name)
              || "RPARENT".equals(name)
              || "DO".equals(name)
              || "INV".equals(name)
              || "THEN".equals(name)
              || "ENDWHILE".equals(name)
              || "ENDIF".equals(name)
              || "ELSE".equals(name)
              || "ENDPROC".equals(name)
              || "ENDFUN".equals(name)
              || "ENDPROGRAM".equals(name)
              || "POST".equals(name)
              || "SEMI".equals(name)
              || "BECOMES".equals(name)
              || "COR".equals(name)
              || "CAND".equals(name)
              || "OR".equals(name)
              || "AND".equals(name)
              || "GT".equals(name)
              || "LT".equals(name)
              || "NE".equals(name)
              || "EQ".equals(name)
              || "MINUS".equals(name)
              || "PLUS".equals(name)
              || "MOD".equals(name)
              || "DIV".equals(name)
              || "TIMES".equals(name)) {
              LOG.debug("factor21 ::= <e>");
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void factor211() throws GrammarError {
        String name = terminal.getName();
        if("INIT".equals(name)) {
            LOG.debug("factor211 ::= INIT");
            consume(terminal);
        } else if("LPARENT".equals(name)) {
            LOG.debug("factor211 ::= exprList");
            exprList();
        } else {
            handleInvalidToken();
        }
    }

    @Override
    public void factor3() throws GrammarError {
        String name = terminal.getName();
        if("MINUS".equals(name)
            || "PLUS".equals(name)
            || "NOT".equals(name)) {
            LOG.debug("factor3 ::= monadicOpr factor");
            monadicOpr();
            factor();
        } else {
            handleInvalidToken();
        }
    }

    @Override
    public void factor4() throws GrammarError {
        String name = terminal.getName();
        if("OLD".equals(name)
            || "PLUS".equals(name)
            || "NOT".equals(name)) {
            LOG.debug("factor4 ::= OLD LPARENT expr RPARENT");
            consume(terminal);
            consume("LPARENT");
            expr();
            consume("RPARENT");
        } else {
            handleInvalidToken();
        }
    }

    @Override
    public void factor5() throws GrammarError {
        String name = terminal.getName();
        if("LPARENT".equals(name)) {
            LOG.debug("factor5 ::= LPARENT expr RPARENT");
            consume(terminal);
            expr();
            consume("RPARENT");
        } else {
            handleInvalidToken();
        }
    }

    @Override
    public void monadicOpr() throws GrammarError {
        String name = terminal.getName();
        if("NOT".equals(name)) {
             LOG.debug("monadicOpr ::= NOT");
             consume(terminal);
        } else if("MINUS".equals(name)
            || "PLUS".equals(name)) {
            LOG.debug("monadicOpr ::= addopr");
            addopr();
        } else {
            handleInvalidToken();
        }
    }

    @Override
    public void exprList1() throws GrammarError {
        String name = terminal.getName();
        if("LPARENT".equals(name)
            || "OLD".equals(name)
            || "MINUS".equals(name)
            || "PLUS".equals(name)
            || "NOT".equals(name)
            || "IDENT".equals(name)
            || "INTVAL32".equals(name)
            || "TRUE".equals(name)
            || "FALSE".equals(name)) {
             LOG.debug("exprList1 ::= exprList2");
             exprList2();
         } else if("RPARENT".equals(name)) {
             LOG.debug("exprList1 ::= <e>");
         }
         else {
             handleInvalidToken();
         }
    }

    @Override
    public void exprList2() throws GrammarError {
        String name = terminal.getName();
        if("LPARENT".equals(name)
                || "OLD".equals(name)
                || "MINUS".equals(name)
                || "PLUS".equals(name)
                || "NOT".equals(name)
                || "IDENT".equals(name)
                || "INTVAL32".equals(name)
                || "TRUE".equals(name)
                || "FALSE".equals(name)) {
             LOG.debug("exprList2 ::= expr exprList3");
             expr();
             exprList3();
         } else {
             handleInvalidToken();
         }
    }

    @Override
    public void exprList3() throws GrammarError {
        String name = terminal.getName();
        if("COMMA".equals(name)) {
             LOG.debug("exprList3 ::= exprList4 exprList3");
             exprList4();
             exprList3();
         } else if("RPARENT".equals(name)) {
             LOG.debug("exprList3 ::= <e>");
         } else {
             handleInvalidToken();
         }
    }

    @Override
    public void exprList4() throws GrammarError {
        String name = terminal.getName();
        if("COMMA".equals(name)) {
             LOG.debug("exprList4 ::= COMMA expr");
             consume(terminal);
             expr();
         } else {
             handleInvalidToken();
         }
    }

    @Override
    public void boolval() throws GrammarError {
        String name = terminal.getName();
        if("FALSE".equals(name)) {
            LOG.debug("boolval ::= FALSE");
            consume(terminal);
        } else if("TRUE".equals(name)) {
            LOG.debug("boolval ::= TRUE");
            consume(terminal);
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void cmd1() throws GrammarError {
        String name = terminal.getName();
        if("LPARENT".equals(name) 
                || "IDENT".equals(name)
                || "INTVAL32".equals(name)
                || "TRUE".equals(name) || "FALSE".equals(name)
                || "MINUS".equals(name) || "PLUS".equals(name)
                || "NOT".equals(name)
                || "OLD".equals(name)) {
            LOG.debug("cmd1 ::= expr BECOMES expr");
            expr();
            consume("BECOMES");
            expr();
            cmd1();
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void cmd2() throws GrammarError {
        String name = terminal.getName();
        if("IF".equals(name)) {
            LOG.debug("cmd2 ::= IF expr THEN cpsCmd ELSE cpsCmd ENDIF");
            consume(terminal);
            expr();
            consume("THEN");
            cpsCmd();
            consume("ELSE");
            cpsCmd();
            consume("ENDIF");
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void cmd3() throws GrammarError {
        String name = terminal.getName();
        if("WHILE".equals(name)) {
            LOG.debug("cmd3 ::= WHILE expr cmd31 DO cpsCmd ENDWHILE");
            consume(terminal);
            expr();
            cmd31();
            consume("DO");
            cpsCmd();
            consume("ENDWHILE");
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void cmd31() throws GrammarError {
        String name = terminal.getName();
        if("INV".equals(name)) {
            LOG.debug("cmd31 ::= invariant");
            invariant();
        }
        else if("DO".equals(name)) {
            LOG.debug("cmd31 ::= <e>");
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void cmd4() throws GrammarError {
        String name = terminal.getName();
        if("CALL".equals(name)) {
            LOG.debug("cmd4 ::= CALL IDENT exprList cmd41");
            consume(terminal);
            consume("IDENT");
            exprList();
            cmd41();
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void cmd5() throws GrammarError {
        String name = terminal.getName();
        if("DEBUGIN".equals(name)) {
            LOG.debug("cmd5 ::= DEBUGIN expr");
            consume(terminal);
            expr();
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void cmd6() throws GrammarError {
        String name = terminal.getName();
        if("DEBUGOUT".equals(name)) {
            LOG.debug("cmd6 ::= DEBUGOUT expr");
            consume(terminal);
            expr();
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void cmd7() throws GrammarError {
        String name = terminal.getName();
        if("ASSERT".equals(name)) {
            LOG.debug("cmd7 ::= ASSERT expr");
            consume(terminal);
            expr();
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void literal() throws GrammarError {
        String name = terminal.getName();
        if("TRUE".equals(name) || "FALSE".equals(name)) {
            LOG.debug("literal ::= boolval");
            boolval();
        } else if("INTVAL32".equals(name)) {
            LOG.debug("literal ::= INTVAL32");
            consume(terminal);
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void precondition() throws GrammarError {
        String name = terminal.getName();
        if("PRE".equals(name)) {
            LOG.debug("precondition ::= PRE IDENT COLON expr");
            consume(terminal);
            consume("IDENT");
            consume("COLON");
            expr();
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void postcondition() throws GrammarError {
        String name = terminal.getName();
        if("POST".equals(name)) {
            LOG.debug("postcondition ::= POST IDENT COLON expr");
            consume(terminal);
            consume("IDENT");
            consume("COLON");
            expr();
        }
        else {
            handleInvalidToken();
        }
    }

    @Override
    public void invariant() throws GrammarError {
        String name = terminal.getName();
        if("INV".equals(name)) {
            LOG.debug("invariant ::= INV IDENT COLON expr");
            consume(terminal);
            consume("IDENT");
            consume("COLON");
            expr();
        }
        else {
            handleInvalidToken();
        }
    }
    
    private void handleInvalidToken() throws GrammarError {
        String errorMsg = "Unexpected token "+token.getType().getName()+" at position"+token.getStart();
        LOG.error(errorMsg);
        throw new GrammarError(errorMsg);
    }

}
