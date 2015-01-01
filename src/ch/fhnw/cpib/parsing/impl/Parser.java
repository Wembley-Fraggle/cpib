package ch.fhnw.cpib.parsing.impl;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import ch.fhnw.cpib.errors.GrammarError;
import ch.fhnw.cpib.lexing.ITerminal;
import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.*;

public class Parser implements IParser, IConcSyn {

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
    public IProgram program() throws GrammarError {
        String name = terminal.getName();
        if ("PROGRAM".equals(name)) {
            LOG.debug("program ::= PROGRAM IDENT progParamList program1 program2 program3 DO cpsCmd program4 ENDPROGRAM");
            return new Program(consume(terminal), consume("IDENT"),
                    progParamList(), program1(), program2(), program3(),
                    consume("DO"), cpsCmd(), program4(), consume("ENDPROGRAM"));
        } else {
            throw createError();
        }
    }

    @Override
    public IProgram1 program1() throws GrammarError {
        String name = terminal.getName();
        if ("INV".equals(name)) {
            LOG.debug("program1 ::= invariant");
            return new Program1(invariant());
        } else if ("DO".equals(name) || "PRE".equals(name)
                || "GLOBAL".equals(name)) {
            LOG.debug("program1 ::= <e>");
            return new Program1Eps();
        } else {
            throw createError();
        }
    }

    @Override
    public IProgram2 program2() throws GrammarError {
        String name = terminal.getName();
        if ("GLOBAL".equals(name)) {
            LOG.debug("program2 ::= program21");
            return new Program2(program21());
        } else if ("DO".equals(name) || "GLOBAL".equals(name)) {
            LOG.debug("program2 ::= <e>");
            return new Program2Eps();
        } else {
            throw createError();
        }
    }

    @Override
    public IProgram21 program21() throws GrammarError {
        String name = terminal.getName();
        if ("GLOBAL".equals(name)) {
            LOG.debug("program21 ::= GLOBAL cpsDecl");
            return new Program21(consume(terminal), cpsDecl());
        } else {
            throw createError();
        }
    }

    @Override
    public IProgram3 program3() throws GrammarError {
        String name = terminal.getName();
        if ("PRE".equals(name)) {
            LOG.debug("program3 ::= precondition");
            precondition();
            return null; // TODO
        } else if ("DO".equals(name)) {
            LOG.debug("program3 ::= <e>");
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public IProgram4 program4() throws GrammarError {
        String name = terminal.getName();
        if ("POST".equals(name)) {
            LOG.debug("program4 ::= postcondition");
            postcondition();
            return null; // TODO
        } else if ("ENDPROGRAM".equals(name)) {
            LOG.debug("program4 ::= <e>");
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public IProgParamList progParamList() throws GrammarError {
        String name = terminal.getName();
        if ("LPARENT".equals(name)) {
            LOG.debug("progParamList ::= LPARENT progParamList1 RPARENT");
            consume(terminal);
            progParamList1();
            consume("RPARENT");
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public ICpsCmd cpsCmd() throws GrammarError {
        String name = terminal.getName();
        if ("ASSERT".equals(name) || "DEBUGOUT".equals(name)
                || "DEBUGIN".equals(name) || "CALL".equals(name)
                || "WHILE".equals(name) || "IF".equals(name)
                || "LPARENT".equals(name) || "OLD".equals(name)
                || "MINUS".equals(name) || "PLUS".equals(name)
                || "NOT".equals(name) || "IDENT".equals(name)
                || "INTVAL32".equals(name) || "TRUE".equals(name)
                || "FALSE".equals(name) || "SKIP".equals(name)) {
            LOG.debug("cpsCmd ::= cmd cpsCmd1");
            return new CpsCmd(cmd(), cpsCmd1());
        } else {
            throw createError();
        }
    }

    @Override
    public ICpsDecl cpsDecl() throws GrammarError {
        String name = terminal.getName();
        if ("PROC".equals(name) || "FUN".equals(name) || "IDENT".equals(name)
                || "VAR".equals(name) || "CONST".equals(name)) {
            LOG.debug("cpsDecl ::= decl cpsDecl1");
            return new CpsDecl(decl(), cpsDecl1());
        } else {
            throw createError();
        }
    }

    @Override
    public IStoDecl stoDecl() throws GrammarError {
        String name = terminal.getName();
        if ("IDENT".equals(name) || "VAR".equals(name) || "CONST".equals(name)) {
            LOG.debug("stoDecl ::= stoDecl1 typedIdent");
            return new StoDecl(stoDecl1(), typedIdent());
        } else {
            throw createError();
        }
    }

    @Override
    public IStoDecl1 stoDecl1() throws GrammarError {
        String name = terminal.getName();
        if ("VAR".equals(name) || "CONST".equals(name)) {
            LOG.debug("stoDecl1 ::= changemode");
            return new StoDecl1(changemode());
        } else if ("IDENT".equals(name)) {
            LOG.debug("stoDecl1 ::= <e>");
            return new StoDecl1Eps();
        } else {
            throw createError();
        }
    }

    @Override
    public IFunDecl funDecl() throws GrammarError {
        String name = terminal.getName();
        if ("FUN".equals(name)) {
            LOG.debug("funDecl ::= FUN IDENT paramList RETURNS stoDecl funDecl1 funDecl2 funDecl3 DO cpsCmd funDecl4 ENDFUN");
            return new FunDecl(
            consume(terminal),
            consume("IDENT"),
            paramList(),
            consume("RETURNS"),
            stoDecl(),
            funDecl1(),
            funDecl2(),
            funDecl3(),
            consume("DO"),
            cpsCmd(),
            funDecl4(),
            consume("ENDFUN"));
        } else {
            throw createError();
        }
    }

    @Override
    public IFunDecl1 funDecl1() throws GrammarError {
        String name = terminal.getName();
        if ("GLOBAL".equals(name)) {
            LOG.debug("funDecl1 ::= funDecl11");
            return new FunDecl1(
            funDecl11());
        } else if ("DO".equals(name) || "PRE".equals(name)
                || "LOCAL".equals(name)) {
            LOG.debug("funDecl1 ::= <e>");
            return new FunDecl1Eps();
        } else {
            throw createError();
        }
    }

    @Override
    public IFunDecl11 funDecl11() throws GrammarError {
        String name = terminal.getName();
        if ("GLOBAL".equals(name)) {
            LOG.debug("funDecl11 ::= GLOBAL globImps");
            return new FunDecl11(
            consume(terminal),
            globImps());
        } else {
            throw createError();
        }
    }

    @Override
    public IFunDecl2 funDecl2() throws GrammarError {
        String name = terminal.getName();
        if ("LOCAL".equals(name)) {
            LOG.debug("funDecl2 ::= funDecl21");
            return new FunDecl2(
            funDecl21());
        } else if ("DO".equals(name) || "PRE".equals(name)) {
            LOG.debug("funDecl2 ::= <e>");
            return new FunDecl2Eps();
        } else {
            throw createError();
        }
    }

    @Override
    public IFunDecl21 funDecl21() throws GrammarError {
        String name = terminal.getName();
        if ("LOCAL".equals(name)) {
            LOG.debug("funDecl21 ::= LOCAL cpsStoDecl");
            return new FunDecl21(
            consume(terminal),
            cpsStoDecl());
        } else {
            throw createError();
        }
    }

    @Override
    public IFunDecl3 funDecl3() throws GrammarError {
        String name = terminal.getName();
        if ("PRE".equals(name)) {
            LOG.debug("funDecl3 ::= precondition");
            return new FunDecl3(
            precondition());
        } else if ("DO".equals(name)) {
            LOG.debug("funDecl3 ::= <e>");
            return new FunDecl3Eps();
        } else {
            throw createError();
        }
    }

    @Override
    public IFunDecl4 funDecl4() throws GrammarError {
        String name = terminal.getName();
        if ("POST".equals(name)) {
            LOG.debug("funDecl4 ::= postcondition");
            return new FunDecl4(
            postcondition());
        } else if ("ENDFUN".equals(name)) {
            LOG.debug("funDecl4 ::= <e>");
            return new FunDecl4Eps();
        } else {
            throw createError();
        }
    }

    @Override
    public IProcDecl procDecl() throws GrammarError {
        String name = terminal.getName();
        if ("PROC".equals(name)) {
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
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public ITypedIdent typedIdent() throws GrammarError {
        String name = terminal.getName();
        if ("IDENT".equals(name)) {
            LOG.debug("typedIdent ::= IDENT COLON atomtype");
            consume(terminal);
            consume("COLON");
            atomtype();
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public IChangemode changemode() throws GrammarError {
        String name = terminal.getName();
        if ("CONST".equals(name)) {
            LOG.debug("changemode ::= CONST");
            consume(terminal);
            return null; // TODO
        } else if ("VAR".equals(name)) {
            LOG.debug("changemode ::= VAR");
            consume(terminal);
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public IParamList paramList() throws GrammarError {
        String name = terminal.getName();
        if ("LPARENT".equals(name)) {
            LOG.debug("paramList1 ::= LPARENT paramList1 RPARENT");
            consume(terminal);
            paramList1();
            consume("RPARENT");
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public IGlobImps globImps() throws GrammarError {
        String name = terminal.getName();
        if ("IDENT".equals(name) || "VAR".equals(name) || "CONST".equals(name)
                || "OUT".equals(name) || "INOUT".equals(name)
                || "IN".equals(name)) {
            LOG.debug("globImps ::= globImp globImps1");
            globImp();
            globImps1();
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public ICpsStoDecl cpsStoDecl() throws GrammarError {
        String name = terminal.getName();
        if ("IDENT".equals(name) || "VAR".equals(name) || "CONST".equals(name)) {
            LOG.debug("cpsStoDecl ::= stoDecl cpsStoDecl1");
            stoDecl();
            cpsStoDecl1();
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public IProcDecl1 procDecl1() throws GrammarError {
        String name = terminal.getName();
        if ("GLOBAL".equals(name)) {
            LOG.debug("procDecl1 ::= procDecl11");
            procDecl11();
            return null; // TODO
        } else if ("DO".equals(name) || "PRE".equals(name)
                || "LOCAL".equals(name)) {
            LOG.debug("procDecl1 ::= <e>");
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public IProcDecl11 procDecl11() throws GrammarError {
        String name = terminal.getName();
        if ("GLOBAL".equals(name)) {
            LOG.debug("procDecl11 ::= GLOBAL globImps");
            consume(terminal);
            globImps();
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public IProcDecl2 procDecl2() throws GrammarError {
        String name = terminal.getName();
        if ("LOCAL".equals(name)) {
            LOG.debug("procDecl2 ::= procDecl21");
            procDecl21();
            return null; // TODO
        } else if ("DO".equals(name) || "PRE".equals(name)) {
            LOG.debug("procDecl2 ::= <e>");
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public IProcDecl21 procDecl21() throws GrammarError {
        String name = terminal.getName();
        if ("LOCAL".equals(name)) {
            LOG.debug("procDecl21 ::= LOCAL cpsStoDecl");
            consume(terminal);
            cpsStoDecl();
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public IProcDecl3 procDecl3() throws GrammarError {
        String name = terminal.getName();
        if ("PRE".equals(name)) {
            LOG.debug("procDecl3 ::= precondition");
            precondition();
            return null; // TODO
        } else if ("DO".equals(name)) {
            LOG.debug("procDecl3 ::= <e>");
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public IProcDecl4 procDecl4() throws GrammarError {
        String name = terminal.getName();
        if ("POST".equals(name)) {
            LOG.debug("procDecl4 ::= postcondition");
            postcondition();
            return null; // TODO
        } else if ("ENDPROC".equals(name)) {
            LOG.debug("procDecl4 ::= <e>");
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public IGlobImp globImp() throws GrammarError {
        String name = terminal.getName();
        if ("IDENT".equals(name) || "VAR".equals(name) || "CONST".equals(name)
                || "OUT".equals(name) || "INOUT".equals(name)
                || "IN".equals(name)) {
            LOG.debug("globImp ::= globImp1 globImp2 IDENT");
            globImp1();
            globImp2();
            consume("IDENT");
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public IGlobImps1 globImps1() throws GrammarError {
        String name = terminal.getName();
        if ("COMMA".equals(name)) {
            LOG.debug("globImps1 ::= globImps2 globImps1");
            globImps2();
            globImps1();
            return null; // TODO
        } else if ("DO".equals(name) || "PRE".equals(name)
                || "LOCAL".equals(name)) {
            LOG.debug("globImps1 ::= <e>");
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public IGlobImps2 globImps2() throws GrammarError {
        String name = terminal.getName();
        if ("COMMA".equals(name)) {
            LOG.debug("globImps2 ::= COMMA globImp");
            consume(terminal);
            globImp();
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public IGlobImp1 globImp1() throws GrammarError {
        String name = terminal.getName();
        if ("OUT".equals(name) || "INOUT".equals(name) || "IN".equals(name)) {
            LOG.debug("globImp1 ::= flowmode");
            flowmode();
            return null; // TODO
        } else if ("IDENT".equals("IDENT") || "VAR".equals("IDENT")
                || "CONST".equals("IDENT")) {
            LOG.debug("globImp1 ::= <e>");
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public IGlobImp2 globImp2() throws GrammarError {
        String name = terminal.getName();
        if ("VAR".equals(name) || "CONST".equals(name)) {
            LOG.debug("globImp2 ::= changemode");
            changemode();
            return null; // TODO
        }
        else if ("IDENT".equals(name)) {
            LOG.debug("globImp2 ::= <e>");
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public IFlowmode flowmode() throws GrammarError {
        String name = terminal.getName();
        if ("IN".equals(name)) {
            LOG.debug("flowmode ::= IN");
            consume(terminal);
            return null; // TODO
        } else if ("INOUT".equals(name)) {
            LOG.debug("flowmode ::= INOUT");
            consume(terminal);
            return null; // TODO
        } else if ("OUT".equals(name)) {
            LOG.debug("flowmode ::= OUT");
            consume(terminal);
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public IDecl decl() throws GrammarError {
        String name = terminal.getName();
        if ("IDENT".equals(name) || "VAR".equals(name) || "CONST".equals(name)) {
            LOG.debug("decl ::= stoDecl");
            stoDecl();
            return null; // TODO
        } else if ("FUN".equals(name)) {
            LOG.debug("decl ::= funDecl");
            funDecl();
            return null; // TODO
        } else if ("PROC".equals(name)) {
            LOG.debug("decl ::= procDecl");
            procDecl();
            return null; // TODO
        } else {
            throw createError();
        }

    }

    @Override
    public ICpsDecl1 cpsDecl1() throws GrammarError {
        String name = terminal.getName();
        if ("SEMI".equals(name)) {
            LOG.debug("cpsDecl1 ::= cpsDecl2 cpsDecl1");
            cpsDecl2();
            cpsDecl1();
            return null; // TODO
        } else if ("DO".equals(name) || "PRE".equals(name)) {
            LOG.debug("cpsDecl1 ::= <e>");
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public ICpsDecl2 cpsDecl2() throws GrammarError {
        String name = terminal.getName();
        if ("SEMI".equals(name)) {
            LOG.debug("cpsDecl2 ::= SEMI decl");
            consume(terminal);
            decl();
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public ICpsStoDecl1 cpsStoDecl1() throws GrammarError {
        String name = terminal.getName();
        if ("SEMI".equals(name)) {
            LOG.debug("cpsStoDecl1 ::= cpsStoDecl2 cpsStoDecl1");
            cpsStoDecl2();
            cpsStoDecl1();
            return null; // TODO
        } else if ("DO".equals(name) || "PRE".equals(name)) {
            LOG.debug("cpsStoDecl1 ::= <e>");
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public ICpsStoDecl2 cpsStoDecl2() throws GrammarError {
        String name = terminal.getName();
        if ("SEMI".equals(name)) {
            LOG.debug("cpsStoDecl2 ::= SEMI stoDecl");
            consume(terminal);
            stoDecl();
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public IProgParamList1 progParamList1() throws GrammarError {
        String name = terminal.getName();
        if ("IDENT".equals(name) || "VAR".equals(name) || "CONST".equals(name)
                || "OUT".equals(name) || "INOUT".equals(name)
                || "IN".equals(name)) {
            LOG.debug("progParamList1 ::= progParamList2");
            progParamList2();
            return null; // TODO
        } else if ("RPARENT".equals(name)) {
            LOG.debug("progParamList1 ::= <e>");
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public IProgParamList2 progParamList2() throws GrammarError {
        String name = terminal.getName();
        if ("IDENT".equals(name) || "VAR".equals(name) || "CONST".equals(name)
                || "OUT".equals(name) || "INOUT".equals(name)
                || "IN".equals(name)) {
            LOG.debug("progParamList2 ::= progParam progParamList3");
            progParam();
            progParamList3();
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public IProgParam progParam() throws GrammarError {
        String name = terminal.getName();
        if ("IDENT".equals(name) || "VAR".equals(name) || "CONST".equals(name)
                || "OUT".equals(name) || "INOUT".equals(name)
                || "IN".equals(name)) {
            LOG.debug("progParam ::= progParam1 progParam2 typedIdent");
            progParam1();
            progParam2();
            typedIdent();
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public IProgParamList3 progParamList3() throws GrammarError {
        String name = terminal.getName();
        if ("COMMA".equals(name)) {
            LOG.debug("progParamList3 ::= progParamList4 progParamList3");
            progParam();
            progParamList3();
            return null; // TODO
        } else if ("RPARENT".equals(name)) {
            LOG.debug("progParamList3 ::= <e>");
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public IProgParamList4 progParamList4() throws GrammarError {
        String name = terminal.getName();
        if ("COMMA".equals(name)) {
            LOG.debug("progParamList4 ::= COMMA progParam");
            consume(terminal);
            progParam();
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public IProgParam1 progParam1() throws GrammarError {
        String name = terminal.getName();
        if ("OUT".equals(name) || "INOUT".equals(name) || "IN".equals(name)) {
            LOG.debug("progParam1 ::= flowmode");
            flowmode();
            return null; // TODO
        } else if ("IDENT".equals(name) || "VAR".equals(name)
                || "CONST".equals(name)) {
            LOG.debug("progParam1 ::= <e>");
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public IProgParam2 progParam2() throws GrammarError {
        String name = terminal.getName();
        if ("VAR".equals(name) || "CONST".equals(name)) {
            LOG.debug("progParam2 ::= changemode");
            changemode();
            return null; // TODO
        } else if ("IDENT".equals(name)) {
            LOG.debug("progParam2 ::= <e>");
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public IParamList1 paramList1() throws GrammarError {
        String name = terminal.getName();
        if ("IDENT".equals(name) || "VAR".equals(name) || "CONST".equals(name)
                || "REF".equals(name) || "COPY".equals(name)
                || "OUT".equals(name) || "INOUT".equals(name)
                || "IN".equals(name)) {
            LOG.debug("paramList1 ::= paramList2");
            paramList2();
            return null; // TODO
        } else if ("RPARENT".equals(name)) {
            LOG.debug("paramList1 ::= <e>");
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public IParamList2 paramList2() throws GrammarError {
        String name = terminal.getName();
        if ("IDENT".equals(name) || "VAR".equals(name) || "CONST".equals(name)
                || "REF".equals(name) || "COPY".equals(name)
                || "OUT".equals(name) || "INOUT".equals(name)
                || "IN".equals(name)) {
            LOG.debug("paramList2 ::= param paramList3");
            param();
            paramList3();
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public IParamList3 paramList3() throws GrammarError {
        String name = terminal.getName();
        if ("COMMA".equals(name)) {
            LOG.debug("paramList3 ::= paramList4 paramList3");
            paramList4();
            paramList3();
            return null; // TODO
        } else if ("RPARENT".equals(name)) {
            LOG.debug("paramList3 ::= <e>");
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public IParam param() throws GrammarError {
        String name = terminal.getName();
        if ("IDENT".equals(name) || "VAR".equals(name) || "CONST".equals(name)
                || "REF".equals(name) || "COPY".equals(name)
                || "OUT".equals(name) || "INOUT".equals(name)
                || "IN".equals(name)) {
            LOG.debug("param ::= param1 param2 param3 typedIdent");
            param1();
            param2();
            param3();
            typedIdent();
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public IParamList4 paramList4() throws GrammarError {
        String name = terminal.getName();
        if ("COMMA".equals(name)) {
            LOG.debug("paramList4 ::= COMMA param");
            consume(terminal);
            param();
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public IParam1 param1() throws GrammarError {
        String name = terminal.getName();
        if ("OUT".equals(name) || "INOUT".equals(name) || "IN".equals(name)) {
            LOG.debug("param1 ::= flowmode");
            flowmode();
            return null; // TODO
        } else if ("IDENT".equals(name) || "VAR".equals(name)
                || "CONST".equals(name) || "REF".equals(name)
                || "COPY".equals(name)) {
            LOG.debug("param1 ::= <e>");
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public IParam2 param2() throws GrammarError {
        String name = terminal.getName();
        if ("REF".equals(name) || "COPY".equals(name)) {
            LOG.debug("param2 ::= mechmode");
            mechmode();
            return null; // TODO
        } else if ("IDENT".equals(name) || "VAR".equals(name)
                || "CONST".equals(name)) {
            LOG.debug("param2 ::= <e>");
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public IParam3 param3() throws GrammarError {
        String name = terminal.getName();
        if ("VAR".equals(name) || "CONST".equals(name)) {
            LOG.debug("param3 ::= changemode");
            changemode();
            return null; // TODO
        } else if ("IDENT".equals(name)) {
            LOG.debug("param3 ::= <e>");
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public IMechmode mechmode() throws GrammarError {
        String name = terminal.getName();
        if ("COPY".equals(name)) {
            LOG.debug("mechmode ::= COPY");
            consume(terminal);
            return null; // TODO
        } else if ("REF".equals(name)) {
            LOG.debug("mechmode ::= REF");
            consume(terminal);
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public IAtomtype atomtype() throws GrammarError {
        String name = terminal.getName();
        if ("BOOL".equals(name)) {
            LOG.debug("atomtype ::= BOOL");
            consume(terminal);
            return null; // TODO
        } else if ("INT32".equals(name)) {
            LOG.debug("atomtype ::= INT32");
            consume(terminal);
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public IExpr expr() throws GrammarError {
        String name = terminal.getName();
        if ("LPARENT".equals(name) || "OLD".equals(name)
                || "MINUS".equals(name) || "PLUS".equals(name)
                || "NOT".equals(name) || "IDENT".equals(name)
                || "INTVAL32".equals(name) || "TRUE".equals(name)
                || "FALSE".equals(name)) {
            LOG.debug("expr ::= term1 expr1");
            term1();
            expr1();
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public IExprList exprList() throws GrammarError {
        String name = terminal.getName();
        if ("LPARENT".equals(name)) {
            LOG.debug("exprList ::= LPARENT exprList1 RPARENT");
            consume(terminal);
            exprList1();
            consume("RPARENT");
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public ICmd41 cmd41() throws GrammarError {
        String name = terminal.getName();
        if ("INIT".equals(name) || "CONST".equals(name)) {
            LOG.debug("cmd41 ::= globInits");
            globInits();
            return null; // TODO
        } else if ("ENDWHILE".equals(name) || "ENDIF".equals(name)
                || "ELSE".equals(name) || "ENDPROC".equals(name)
                || "ENDFUN".equals(name) || "ENDPROGRAM".equals(name)
                || "POST".equals(name) || "SEMI".equals(name)) {
            LOG.debug("cmd41 ::= <e>");
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public IGlobInits globInits() throws GrammarError {
        String name = terminal.getName();
        if ("INIT".equals(name)) {
            LOG.debug("globInits ::= INIT idents");
            consume(terminal);
            idents();
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public ICpsCmd1 cpsCmd1() throws GrammarError {
        String name = terminal.getName();
        if ("SEMI".equals(name)) {
            LOG.debug("cpsCmd1 ::= cpsCmd2 cpsCmd1");
            cpsCmd2();
            cpsCmd1();
            return null; // TODO
        } else if ("ENDWHILE".equals(name) || "ENDIF".equals(name)
                || "ELSE".equals(name) || "ENDPROC".equals(name)
                || "ENDFUN".equals(name) || "ENDPROGRAM".equals(name)
                || "POST".equals(name)) {
            LOG.debug("cpsCmd1 ::= <e>");
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public ICpsCmd2 cpsCmd2() throws GrammarError {
        String name = terminal.getName();
        if ("SEMI".equals(name)) {
            LOG.debug("cpsCmd2 ::= SEMI cmd");
            consume(terminal);
            cmd();
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public ICmd cmd() throws GrammarError {
        String name = terminal.getName();
        if ("SKIP".equals(name)) {
            LOG.debug("cmd ::= SKIP");
            consume(terminal);
            return null; // TODO
        } else if ("LPARENT".equals(name) || "OLD".equals(name)
                || "MINUS".equals(name) || "PLUS".equals(name)
                || "NOT".equals(name) || "IDENT".equals(name)
                || "INTVAL32".equals(name) || "TRUE".equals(name)
                || "FALSE".equals(name)) {
            LOG.debug("cmd ::= cmd1");
            cmd1();
            return null; // TODO
        } else if ("IF".equals(name)) {
            LOG.debug("cmd ::= cmd2");
            cmd2();
            return null; // TODO
        } else if ("WHILE".equals(name)) {
            LOG.debug("cmd ::= cmd3");
            cmd3();
            return null; // TODO
        } else if ("CALL".equals(name)) {
            LOG.debug("cmd ::= cmd4");
            cmd4();
            return null; // TODO
        } else if ("DEBUGIN".equals(name)) {
            LOG.debug("cmd ::= cmd5");
            cmd5();
            return null; // TODO
        } else if ("DEBUGOUT".equals(name)) {
            LOG.debug("cmd ::= cmd6");
            cmd6();
            return null; // TODO
        } else if ("ASSERT".equals(name)) {
            LOG.debug("cmd ::= cmd7");
            cmd7();
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public IIdents idents() throws GrammarError {
        String name = terminal.getName();
        if ("IDENT".equals(name)) {
            LOG.debug("idents ::= IDENT idents1");
            consume(terminal);
            idents1();
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public IIdents1 idents1() throws GrammarError {
        String name = terminal.getName();
        if ("COMMA".equals(name)) {
            LOG.debug("idents1 ::= idents2 idents1");
            idents2();
            idents1();
            return null; // TODO
        } else if ("ENDWHILE".equals(name) || "ENDIF".equals(name)
                || "ELSE".equals(name) || "ENDPROC".equals(name)
                || "ENDFUN".equals(name) || "ENDPROGRAM".equals(name)
                || "POST".equals(name) || "SEMI".equals(name)) {
            LOG.debug("idents1 ::= <e>");
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public IIdents2 idents2() throws GrammarError {
        String name = terminal.getName();
        if ("COMMA".equals(name)) {
            LOG.debug("idents2 ::= COMMA IDENT");
            consume(terminal);
            consume("IDENT");
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public ITerm1 term1() throws GrammarError {
        String name = terminal.getName();
        if ("LPARENT".equals(name) || "OLD".equals(name)
                || "MINUS".equals(name) || "PLUS".equals(name)
                || "NOT".equals(name) || "IDENT".equals(name)
                || "INTVAL32".equals(name) || "TRUE".equals(name)
                || "FALSE".equals(name)) {
            LOG.debug("term1 ::= term2 term11");
            term2();
            term11();
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public IExpr1 expr1() throws GrammarError {
        String name = terminal.getName();
        if ("COR".equals(name) || "CAND".equals(name) || "OR".equals(name)
                || "AND".equals(name)) {
            LOG.debug("expr1 ::= expr2 expr1");
            expr2();
            expr1();
            return null; // TODO
        } else if ("PRE".equals(name) || "GLOBAL".equals(name)
                || "COMMA".equals(name) || "RPARENT".equals(name)
                || "DO".equals(name) || "INV".equals(name)
                || "THEN".equals(name) || "ENDWHILE".equals(name)
                || "ENDIF".equals(name) || "ELSE".equals(name)
                || "ENDPROC".equals(name) || "ENDFUN".equals(name)
                || "ENDPROGRAM".equals(name) || "POST".equals(name)
                || "SEMI".equals(name) || "BECOMES".equals(name)) {
            LOG.debug("expr1 ::= <e>");
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public IExpr2 expr2() throws GrammarError {
        String name = terminal.getName();
        if ("COR".equals(name) || "CAND".equals(name) || "OR".equals(name)
                || "AND".equals(name)) {
            LOG.debug("expr2 ::= boolopr term1");
            boolopr();
            term1();
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public IBoolopr boolopr() throws GrammarError {
        String name = terminal.getName();
        if ("AND".equals(name)) {
            LOG.debug("boolopr ::= AND");
            consume(terminal);
            return null; // TODO
        } else if ("OR".equals(name)) {
            LOG.debug("boolopr ::= OR");
            consume(terminal);
            return null; // TODO
        } else if ("CAND".equals(name)) {
            LOG.debug("boolopr ::= CAND");
            consume(terminal);
            return null; // TODO
        }
        if ("COR".equals(name)) {
            LOG.debug("boolopr ::= COR");
            consume(terminal);
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public ITerm2 term2() throws GrammarError {
        String name = terminal.getName();
        if ("LPARENT".equals(name) || "OLD".equals(name)
                || "MINUS".equals(name) || "PLUS".equals(name)
                || "NOT".equals(name) || "IDENT".equals(name)
                || "INTVAL32".equals(name) || "TRUE".equals(name)
                || "FALSE".equals(name)) {
            LOG.debug("term2 ::= term3 term21");
            term3();
            term21();
            return null; // TODO
        } else {
            throw createError();
        }

    }

    @Override
    public ITerm12 term12() throws GrammarError {
        String name = terminal.getName();
        if ("GT".equals(name) || "LT".equals(name) || "NE".equals(name)
                || "EQ".equals(name)) {
            LOG.debug("term12 ::= relopr term2");
            relopr();
            term2();
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public ITerm11 term11() throws GrammarError {
        String name = terminal.getName();
        if ("GT".equals(name) || "LT".equals(name) || "NE".equals(name)
                || "EQ".equals(name)) {
            LOG.debug("term11 ::= term12");
            term12();
            return null; // TODO
        } else if ("PRE".equals(name) || "GLOBAL".equals(name)
                || "COMMA".equals(name) || "RPARENT".equals(name)
                || "DO".equals(name) || "INV".equals(name)
                || "THEN".equals(name) || "ENDWHILE".equals(name)
                || "ENDIF".equals(name) || "ELSE".equals(name)
                || "ENDPROC".equals(name) || "ENDFUN".equals(name)
                || "ENDPROGRAM".equals(name) || "POST".equals(name)
                || "SEMI".equals(name) || "BECOMES".equals(name)
                || "COR".equals(name) || "CAND".equals(name)
                || "OR".equals(name) || "AND".equals(name)) {
            LOG.debug("term11 ::= <e>");
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public IRelopr relopr() throws GrammarError {
        String name = terminal.getName();
        if ("EQ".equals(name)) {
            LOG.debug("relopr ::= EQ");
            consume(terminal);
            return null; // TODO
        } else if ("NE".equals(name)) {
            LOG.debug("relopr ::= NE");
            consume(terminal);
            return null; // TODO
        } else if ("LT".equals(name)) {
            LOG.debug("relopr ::= LT");
            consume(terminal);
            return null; // TODO
        }
        if ("GT".equals(name)) {
            LOG.debug("relopr ::= GT");
            consume(terminal);
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public ITerm3 term3() throws GrammarError {
        String name = terminal.getName();
        if ("LPARENT".equals(name) || "OLD".equals(name)
                || "MINUS".equals(name) || "PLUS".equals(name)
                || "NOT".equals(name) || "IDENT".equals(name)
                || "INTVAL32".equals(name) || "TRUE".equals(name)
                || "FALSE".equals(name)) {
            LOG.debug("term3 ::= factor term31");
            factor();
            term31();
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public ITerm21 term21() throws GrammarError {
        String name = terminal.getName();
        if ("MINUS".equals(name) || "PLUS".equals(name)) {
            LOG.debug("term21 ::= term211 term21");
            term211();
            term21();
            return null; // TODO
        } else if ("PRE".equals(name) || "GLOBAL".equals(name)
                || "COMMA".equals(name) || "RPARENT".equals(name)
                || "DO".equals(name) || "INV".equals(name)
                || "THEN".equals(name) || "ENDWHILE".equals(name)
                || "ENDIF".equals(name) || "ELSE".equals(name)
                || "ENDPROC".equals(name) || "ENDFUN".equals(name)
                || "ENDPROGRAM".equals(name) || "POST".equals(name)
                || "SEMI".equals(name) || "BECOMES".equals(name)
                || "COR".equals(name) || "CAND".equals(name)
                || "OR".equals(name) || "AND".equals(name) || "GT".equals(name)
                || "LT".equals(name) || "NE".equals(name) || "EQ".equals(name)) {
            LOG.debug("term21 ::= <e>");
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public ITerm211 term211() throws GrammarError {
        String name = terminal.getName();
        if ("MINUS".equals(name) || "PLUS".equals(name)) {
            LOG.debug("term211 ::= addopr term3");
            addopr();
            term3();
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public IAddopr addopr() throws GrammarError {
        String name = terminal.getName();
        if ("PLUS".equals(name)) {
            LOG.debug("addopr ::= PLUS");
            consume(terminal);
            return null; // TODO
        } else if ("MINUS".equals(name)) {
            LOG.debug("addopr ::= MINUS");
            consume(terminal);
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public ITerm31 term31() throws GrammarError {
        String name = terminal.getName();
        if ("MOD".equals(name) || "DIV".equals(name) || "TIMES".equals(name)) {
            LOG.debug("term31 ::= term311 term31");
            term311();
            term31();
            return null; // TODO
        } else if ("PRE".equals(name) || "GLOBAL".equals(name)
                || "COMMA".equals(name) || "RPARENT".equals(name)
                || "DO".equals(name) || "INV".equals(name)
                || "THEN".equals(name) || "ENDWHILE".equals(name)
                || "ENDIF".equals(name) || "ELSE".equals(name)
                || "ENDPROC".equals(name) || "ENDFUN".equals(name)
                || "ENDPROGRAM".equals(name) || "POST".equals(name)
                || "SEMI".equals(name) || "BECOMES".equals(name)
                || "COR".equals(name) || "CAND".equals(name)
                || "OR".equals(name) || "AND".equals(name) || "GT".equals(name)
                || "LT".equals(name) || "NE".equals(name) || "EQ".equals(name)
                || "MINUS".equals(name) || "PLUS".equals(name)) {
            LOG.debug("term31 ::= <e>");
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public ITerm311 term311() throws GrammarError {
        String name = terminal.getName();
        if ("MOD".equals(name) || "DIV".equals(name) || "TIMES".equals(name)) {
            LOG.debug("term311 ::= multopr factor");
            multopr();
            factor();
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public IMultopr multopr() throws GrammarError {
        String name = terminal.getName();
        if ("TIMES".equals(name)) {
            LOG.debug("multopr ::= TIMES");
            consume(terminal);
            return null; // TODO
        } else if ("DIV".equals(name)) {
            LOG.debug("multopr ::= DIV");
            consume(terminal);
            return null; // TODO
        } else if ("MOD".equals(name)) {
            LOG.debug("multopr ::= MOD");
            consume(terminal);
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public IFactor factor() throws GrammarError {
        String name = terminal.getName();
        if ("INTVAL32".equals(name) || "TRUE".equals(name)
                || "FALSE".equals(name)) {
            LOG.debug("factor ::= factor1");
            factor1();
            return null; // TODO
        } else if ("IDENT".equals(name)) {
            LOG.debug("factor ::= factor2");
            factor2();
            return null; // TODO
        } else if ("MINUS".equals(name) || "PLUS".equals(name)
                || "NOT".equals(name)) {
            LOG.debug("factor ::= factor3");
            factor3();
            return null; // TODO
        } else if ("OLD".equals(name)) {
            LOG.debug("factor ::= factor4");
            factor4();
            return null; // TODO
        } else if ("LPARENT".equals(name)) {
            LOG.debug("factor ::= factor5");
            factor5();
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public IFactor1 factor1() throws GrammarError {
        String name = terminal.getName();
        if ("INTVAL32".equals(name) || "TRUE".equals(name)
                || "FALSE".equals(name)) {
            LOG.debug("factor1 ::= literal");
            ILiteral literal =  literal();
            return new Factor1(literal);
        } else {
            throw createError();
        }
    }

    @Override
    public IFactor2 factor2() throws GrammarError {
        String name = terminal.getName();
        if ("IDENT".equals(name)) {
            LOG.debug("factor2 ::= IDENT factor21");
            consume(terminal);
            factor21();
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public IFactor21 factor21() throws GrammarError {
        String name = terminal.getName();
        if ("LPARENT".equals(name) || "INIT".equals(name)) {
            LOG.debug("factor21 ::= factor211");
            factor211();
            return null; // TODO
        } else if ("PRE".equals(name) || "GLOBAL".equals(name)
                || "COMMA".equals(name) || "RPARENT".equals(name)
                || "DO".equals(name) || "INV".equals(name)
                || "THEN".equals(name) || "ENDWHILE".equals(name)
                || "ENDIF".equals(name) || "ELSE".equals(name)
                || "ENDPROC".equals(name) || "ENDFUN".equals(name)
                || "ENDPROGRAM".equals(name) || "POST".equals(name)
                || "SEMI".equals(name) || "BECOMES".equals(name)
                || "COR".equals(name) || "CAND".equals(name)
                || "OR".equals(name) || "AND".equals(name) || "GT".equals(name)
                || "LT".equals(name) || "NE".equals(name) || "EQ".equals(name)
                || "MINUS".equals(name) || "PLUS".equals(name)
                || "MOD".equals(name) || "DIV".equals(name)
                || "TIMES".equals(name)) {
            LOG.debug("factor21 ::= <e>");
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public IFactor211 factor211() throws GrammarError {
        String name = terminal.getName();
        if ("INIT".equals(name)) {
            LOG.debug("factor211 ::= INIT");
            consume(terminal);
            return null; // TODO
        } else if ("LPARENT".equals(name)) {
            LOG.debug("factor211 ::= exprList");
            exprList();
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public IFactor3 factor3() throws GrammarError {
        String name = terminal.getName();
        if ("MINUS".equals(name) || "PLUS".equals(name) || "NOT".equals(name)) {
            LOG.debug("factor3 ::= monadicOpr factor");
            monadicOpr();
            factor();
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public IFactor4 factor4() throws GrammarError {
        String name = terminal.getName();
        if ("OLD".equals(name)) {
            LOG.debug("factor4 ::= OLD LPARENT expr RPARENT");
            consume(terminal);
            consume("LPARENT");
            expr();
            consume("RPARENT");
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public IFactor5 factor5() throws GrammarError {
        String name = terminal.getName();
        if ("LPARENT".equals(name)) {
            LOG.debug("factor5 ::= LPARENT expr RPARENT");
            consume(terminal);
            expr();
            consume("RPARENT");
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public IMonadicOpr monadicOpr() throws GrammarError {
        String name = terminal.getName();
        if ("NOT".equals(name)) {
            LOG.debug("monadicOpr ::= NOT");
            consume(terminal);
            return null; // TODO
        } else if ("MINUS".equals(name) || "PLUS".equals(name)) {
            LOG.debug("monadicOpr ::= addopr");
            addopr();
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public IExprList1 exprList1() throws GrammarError {
        String name = terminal.getName();
        if ("LPARENT".equals(name) || "OLD".equals(name)
                || "MINUS".equals(name) || "PLUS".equals(name)
                || "NOT".equals(name) || "IDENT".equals(name)
                || "INTVAL32".equals(name) || "TRUE".equals(name)
                || "FALSE".equals(name)) {
            LOG.debug("exprList1 ::= exprList2");
            exprList2();
            return null; // TODO
        } else if ("RPARENT".equals(name)) {
            LOG.debug("exprList1 ::= <e>");
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public IExprList2 exprList2() throws GrammarError {
        String name = terminal.getName();
        if ("LPARENT".equals(name) || "OLD".equals(name)
                || "MINUS".equals(name) || "PLUS".equals(name)
                || "NOT".equals(name) || "IDENT".equals(name)
                || "INTVAL32".equals(name) || "TRUE".equals(name)
                || "FALSE".equals(name)) {
            LOG.debug("exprList2 ::= expr exprList3");
            expr();
            exprList3();
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public IExprList3 exprList3() throws GrammarError {
        String name = terminal.getName();
        if ("COMMA".equals(name)) {
            LOG.debug("exprList3 ::= exprList4 exprList3");
            exprList4();
            exprList3();
            return null; // TODO
        } else if ("RPARENT".equals(name)) {
            LOG.debug("exprList3 ::= <e>");
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public IExprList4 exprList4() throws GrammarError {
        String name = terminal.getName();
        if ("COMMA".equals(name)) {
            LOG.debug("exprList4 ::= COMMA expr");
            consume(terminal);
            expr();
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public IBoolVal boolval() throws GrammarError {
        String name = terminal.getName();
        if ("FALSE".equals(name)) {
            LOG.debug("boolval ::= FALSE");
            consume(terminal);
            return new BoolVal(false);
        } else if ("TRUE".equals(name)) {
            LOG.debug("boolval ::= TRUE");
            consume(terminal);
            return new BoolVal(true);
        } else {
            throw createError();
        }
    }

    @Override
    public ICmd1 cmd1() throws GrammarError {
        String name = terminal.getName();
        if ("LPARENT".equals(name) || "OLD".equals(name)
                || "MINUS".equals(name) || "PLUS".equals(name)
                || "NOT".equals(name) || "IDENT".equals(name)
                || "INTVAL32".equals(name) || "TRUE".equals(name)
                || "FALSE".equals(name)) {
            LOG.debug("cmd1 ::= expr BECOMES expr");
            expr();
            consume("BECOMES");
            expr();
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public ICmd2 cmd2() throws GrammarError {
        String name = terminal.getName();
        if ("IF".equals(name)) {
            LOG.debug("cmd2 ::= IF expr THEN cpsCmd ELSE cpsCmd ENDIF");
            consume(terminal);
            expr();
            consume("THEN");
            cpsCmd();
            consume("ELSE");
            cpsCmd();
            consume("ENDIF");
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public ICmd3 cmd3() throws GrammarError {
        String name = terminal.getName();
        if ("WHILE".equals(name)) {
            LOG.debug("cmd3 ::= WHILE expr cmd31 DO cpsCmd ENDWHILE");
            consume(terminal);
            expr();
            cmd31();
            consume("DO");
            cpsCmd();
            consume("ENDWHILE");
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public ICmd31 cmd31() throws GrammarError {
        String name = terminal.getName();
        if ("INV".equals(name)) {
            LOG.debug("cmd31 ::= invariant");
            invariant();
            return null; // TODO
        } else if ("DO".equals(name)) {
            LOG.debug("cmd31 ::= <e>");
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public ICmd4 cmd4() throws GrammarError {
        String name = terminal.getName();
        if ("CALL".equals(name)) {
            LOG.debug("cmd4 ::= CALL IDENT exprList cmd41");
            consume(terminal);
            consume("IDENT");
            exprList();
            cmd41();
            return null; // TODO
        } else {
            throw createError();
        }
    }

    @Override
    public ICmd5 cmd5() throws GrammarError {
        String name = terminal.getName();
        if ("DEBUGIN".equals(name)) {
            LOG.debug("cmd5 ::= DEBUGIN expr");
            consume(terminal);
            IExpr expr = expr();
            return new Cmd5(expr);
        } else {
            throw createError();
        }
    }

    @Override
    public ICmd6 cmd6() throws GrammarError {
        String name = terminal.getName();
        if ("DEBUGOUT".equals(name)) {
            LOG.debug("cmd6 ::= DEBUGOUT expr");
            consume(terminal);
            IExpr expr = expr();
            return new Cmd6(expr);
        } else {
            throw createError();
        }
    }

    @Override
    public ICmd7 cmd7() throws GrammarError {
        String name = terminal.getName();
        if ("ASSERT".equals(name)) {
            LOG.debug("cmd7 ::= ASSERT expr");
            consume(terminal);
            IExpr expr = expr();
            return new Cmd7(expr);
        } else {
            throw createError();
        }
    }

    @Override
    public ILiteral literal() throws GrammarError {
        String name = terminal.getName();
        if ("TRUE".equals(name) || "FALSE".equals(name)) {
            LOG.debug("literal ::= boolval");
            IBoolVal boolVal =  boolval();
            return new LiteralBool(boolVal);
        } else if ("INTVAL32".equals(name)) {
            LOG.debug("literal ::= INTVAL32");
            String intVal32 = consume(terminal).getValue();
            return new LiteralInt32(Integer.valueOf(intVal32));
        } else {
            throw createError();
        }
    }

    @Override
    public IPrecondition precondition() throws GrammarError {
        String name = terminal.getName();
        if ("PRE".equals(name)) {
            LOG.debug("precondition ::= PRE IDENT COLON expr");
            consume(terminal);
            String ident = consume("IDENT").getValue();
            consume("COLON");
            IExpr expr =  expr();
            return new Precondition(ident, expr);
        } else {
            throw createError();
        }
    }

    @Override
    public IPostcondition postcondition() throws GrammarError {
        String name = terminal.getName();
        if ("POST".equals(name)) {
            LOG.debug("postcondition ::= POST IDENT COLON expr");
            consume(terminal);
            String ident = consume("IDENT").getValue();
            consume("COLON");
            IExpr expr = expr();
            return new Postcondition(ident, expr);
        } else {
            throw createError();
        }
    }

    @Override
    public IInvariant invariant() throws GrammarError {
        String name = terminal.getName();
        if ("INV".equals(name)) {
            LOG.debug("invariant ::= INV IDENT COLON expr");
            consume(terminal);
            String ident = consume("IDENT").getValue();
            consume("COLON");
            IExpr expr = (IExpr)expr();
            return new Invariant(ident, expr);
        } else {
            throw createError();
        }
    }
    
    private GrammarError createError(){
        String errorMsg = "Unexpected token " + token.getType().getName()
                + " at position" + token.getStart();
        LOG.error(errorMsg);
        return new GrammarError(errorMsg);
    }
}
