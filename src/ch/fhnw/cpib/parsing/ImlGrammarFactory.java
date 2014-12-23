package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.lexing.ITerminal;
import ch.fhnw.cpib.lexing.Terminal;
import ch.fhnw.cpib.parsing.nodes.EmptyWord;
import ch.fhnw.cpib.parsing.nodes.IEmptyWord;
import ch.fhnw.cpib.parsing.nodes.INonTerminal;
import ch.fhnw.cpib.parsing.nodes.NonTerminal;

public class ImlGrammarFactory {
    IGrammar grammar;
    IEmptyWord emptyWord;
    ITerminal out;
    ITerminal inout;
    ITerminal in;
    ITerminal boolTrue;
    ITerminal boolFalse;
    ITerminal intVal;
    ITerminal ref;
    ITerminal copy;
    ITerminal varChangeMode;
    ITerminal constChangeMode;
    ITerminal int32;
    ITerminal boolType;
    ITerminal corOpr;
    ITerminal candOpr;
    ITerminal orOpr;
    ITerminal andOpr;
    ITerminal gt;
    ITerminal lt;
    ITerminal ne;
    ITerminal eq;
    ITerminal mod;
    ITerminal div;
    ITerminal times;
    ITerminal minus;
    ITerminal plus;
    ITerminal inv;
    ITerminal pre;
    ITerminal post;
    ITerminal boolNot;
    ITerminal old;
    ITerminal init;
    ITerminal assertCmd;
    ITerminal debugOut;
    ITerminal debugIn;
    ITerminal call;
    ITerminal whileLoop;
    ITerminal endWhile;
    ITerminal condIf;
    ITerminal condThen;
    ITerminal condElse;
    ITerminal condEnd;
    ITerminal becomes;
    ITerminal skip;
    ITerminal colon;
    ITerminal lparent;
    ITerminal rparent;
    ITerminal semicolon;
    ITerminal comma;
    ITerminal proc;
    ITerminal endProc;
    ITerminal local;
    ITerminal fun;
    ITerminal endfun;
    ITerminal returns;
    ITerminal global;
    ITerminal program;
    ITerminal id;
    ITerminal doBlock;
    ITerminal endProgram;
    INonTerminal programNt;
    INonTerminal program1;
    INonTerminal program2;
    INonTerminal program21;
    INonTerminal program3;
    INonTerminal program4;
    INonTerminal decl;
    INonTerminal stoDecl;
    INonTerminal stoDecl1;
    INonTerminal funDecl;
    INonTerminal funDecl1;
    INonTerminal funDecl11;
    INonTerminal funDecl2;
    INonTerminal funDecl21;
    INonTerminal funDecl3;
    INonTerminal funDecl4;
    INonTerminal procDecl;
    INonTerminal procDecl1;
    INonTerminal procDecl11;
    INonTerminal procDecl2;
    INonTerminal procDecl21;
    INonTerminal procDecl3;
    INonTerminal procDecl4;
    INonTerminal globImps;
    INonTerminal globImps1;
    INonTerminal globImps2;
    INonTerminal globImp;
    INonTerminal globImp1;
    INonTerminal globImp2;
    INonTerminal cpsDecl;
    INonTerminal cpsDecl1;
    INonTerminal cpsDecl2;
    INonTerminal cpsStoDecl;
    INonTerminal cpsStoDecl1;
    INonTerminal cpsStoDecl2;
    INonTerminal progParamList;
    INonTerminal progParamList1;
    INonTerminal progParamList2;
    INonTerminal progParamList3;
    INonTerminal progParamList4;
    INonTerminal progParam;
    INonTerminal progParam1;
    INonTerminal progParam2;
    INonTerminal paramList;
    INonTerminal paramList1;
    INonTerminal paramList2;
    INonTerminal paramList3;
    INonTerminal paramList4;
    INonTerminal param;
    INonTerminal param1;
    INonTerminal param2;
    INonTerminal param3;
    INonTerminal typedIdent;
    INonTerminal cmd;
    INonTerminal cmd1;
    INonTerminal cmd2;
    INonTerminal cmd3;
    INonTerminal cmd31;
    INonTerminal cmd4;
    INonTerminal cmd41;
    INonTerminal cmd5;
    INonTerminal cmd6;
    INonTerminal cmd7;
    INonTerminal cpsCmd;
    INonTerminal cpsCmd1;
    INonTerminal cpsCmd2;
    INonTerminal globInits;
    INonTerminal idents;
    INonTerminal idents1;
    INonTerminal idents2;
    INonTerminal expr;
    INonTerminal expr1;
    INonTerminal expr2;
    INonTerminal term1;
    INonTerminal term11;
    INonTerminal term12;
    INonTerminal term2;
    INonTerminal term21;
    INonTerminal term211;
    INonTerminal term3;
    INonTerminal term31;
    INonTerminal term311;
    INonTerminal factor;
    INonTerminal factor1;
    INonTerminal factor2;
    INonTerminal factor21;
    INonTerminal factor211;
    INonTerminal factor3;
    INonTerminal factor4;
    INonTerminal factor5;
    INonTerminal exprList;
    INonTerminal exprList1;
    INonTerminal exprList2;
    INonTerminal exprList3;
    INonTerminal exprList4;
    INonTerminal monadicOpr;
    INonTerminal precondition;
    INonTerminal postcondition;
    INonTerminal invariant;
    INonTerminal addopr;
    INonTerminal multopr;
    INonTerminal relopr;
    INonTerminal boolopr;
    INonTerminal atomtype;
    INonTerminal changemode;
    INonTerminal mechmode;
    INonTerminal literal;
    INonTerminal boolVal;
    INonTerminal flowmode;
    
    IGrammar create() {
        emptyWord = new EmptyWord();
        createTerminals();
        createNonTerminals();
        createProgram();
        createDeclarations();
        createStoDecl();
        createFunDecl();
        createProdcDecl();
        createGlobals();
        createDecls();
        createParamList();
        createProgramParamList();
        createCommands();
        createExpressions();
        createDesignByContract();
        createPrimitives();
        IGrammar result = grammar;
        grammar = null;
        return result;
    }

    private void createTerminals() {
        grammar = new Grammar();
        out = new Terminal("OUT","out");
        inout = new Terminal("INOUT","inout");
        in = new Terminal("IN","in");
        boolTrue = new Terminal("TRUE","true");
        boolFalse = new Terminal("FALSE","false");
        intVal = new Terminal("INTVAL32","[0-9]+");
        ref = new Terminal("REF","ref");
        copy = new Terminal("COPY","copy");
        varChangeMode = new Terminal("VAR","var");
        constChangeMode = new Terminal("CONST","const");
        int32 = new Terminal("INT32", "int32");
        boolType = new Terminal("BOOL","bool");
        corOpr = new Terminal("COR","|?");
        candOpr = new Terminal("CAND","&?");
        orOpr = new Terminal("OR","||");
        andOpr = new Terminal("AND","&&");
        gt = new Terminal("GT",">");
        lt = new Terminal("LT","<");
        ne = new Terminal("NOT_EQUALS","/=");
        eq = new Terminal("EQUALS","=");
        mod = new Terminal("MOD","mod");
        div = new Terminal("DIV","div");
        times = new Terminal("TIMES","*");
        minus = new Terminal("MINUS","-");
        plus = new Terminal("PLUS","+");
        inv = new Terminal("INV","inv");
        pre = new Terminal("PRE","pre");
        post = new Terminal("POST","post");
        boolNot = new Terminal("NOT","not");
        old = new Terminal("OLD","old");
        init = new Terminal("INIT","init");
        assertCmd = new Terminal("ASSERT","assert");
        debugOut = new Terminal("DEBUGOUT","debugout");
        debugIn = new Terminal("DEBUGIN","debugin");
        call = new Terminal("CALL","call");
        whileLoop = new Terminal("WHILE","while");
        endWhile = new Terminal("ENDWHILE","endwhile");
        condIf = new Terminal("IF","if");
        condThen = new Terminal("THEN","then");
        condElse = new Terminal("ELSE","else");
        condEnd = new Terminal("ENDIF","endif");
        becomes = new Terminal("BECOMES",":=");
        skip = new Terminal("SKIP","skip");
        colon = new Terminal("COLON",":");
        lparent = new Terminal("LPARENT","(");
        rparent = new Terminal("RPARENT",")");
        semicolon = new Terminal("SEMICOLON",";");
        comma = new Terminal("COMMA",",");
        proc = new Terminal("PROC","proc");
        endProc = new Terminal("ENDPROC","endproc");
        local = new Terminal("LOCAL","local");
        fun = new Terminal("FUN","fun");
        endfun = new Terminal("ENDFUN","endfun");
        returns = new Terminal("RETURNS","returns");
        global = new Terminal("GLOBAL","global");
        program = new Terminal("PROGRAM","program");
        id = new Terminal("ID","[A-Z][A-Z0-9]*");
        doBlock = new Terminal("DO","do");
        endProgram = new Terminal("ENDPROGRAM","endprogram");
    }
    
    private void createNonTerminals() {
        programNt = new NonTerminal("program");
        program1         = new NonTerminal("program1");
        program2         = new NonTerminal("program2");
        program21        = new NonTerminal("program21");
        program3         = new NonTerminal("program3");
        program4         = new NonTerminal("program4");
        decl             = new NonTerminal("decl");
        stoDecl          = new NonTerminal("stoDecl");
        stoDecl1         = new NonTerminal("stoDecl1");
        funDecl          = new NonTerminal("funDecl");
        funDecl1         = new NonTerminal("funDecl1");
        funDecl11        = new NonTerminal("funDecl11");
        funDecl2         = new NonTerminal("funDecl2");
        funDecl21        = new NonTerminal("funDecl21");
        funDecl3         = new NonTerminal("funDecl3");
        funDecl4         = new NonTerminal("funDecl4");
        procDecl         = new NonTerminal("procDecl");
        procDecl1        = new NonTerminal("procDecl1");
        procDecl11       = new NonTerminal("procDecl11");
        procDecl2        = new NonTerminal("procDecl2");
        procDecl21       = new NonTerminal("procDecl21");
        procDecl3        = new NonTerminal("procDecl3");
        procDecl4        = new NonTerminal("procDecl4");
        globImps         = new NonTerminal("globImps");
        globImps1        = new NonTerminal("globImps1");
        globImps2        = new NonTerminal("globImps2");
        globImp          = new NonTerminal("globImp");
        globImp1         = new NonTerminal("globImp1");
        globImp2         = new NonTerminal("globImp2");
        cpsDecl          = new NonTerminal("cpsDecl");
        cpsDecl1         = new NonTerminal("cpsDecl1");
        cpsDecl2         = new NonTerminal("cpsDecl2");
        cpsStoDecl       = new NonTerminal("cpsStoDecl");
        cpsStoDecl1      = new NonTerminal("cpsStoDecl1");
        cpsStoDecl2      = new NonTerminal("cpsStoDecl2");
        progParamList    = new NonTerminal("progParamList");
        progParamList1   = new NonTerminal("progParamList1");
        progParamList2   = new NonTerminal("progParamList2");
        progParamList3   = new NonTerminal("progParamList3");
        progParamList4   = new NonTerminal("progParamList4");
        progParam        = new NonTerminal("progParam");
        progParam1       = new NonTerminal("progParam1");
        progParam2       = new NonTerminal("progParam2");
        paramList        = new NonTerminal("paramList");
        paramList1       = new NonTerminal("paramList1");
        paramList2       = new NonTerminal("paramList2");
        paramList3       = new NonTerminal("paramList3");
        paramList4       = new NonTerminal("paramList4");
        param            = new NonTerminal("param");
        param1           = new NonTerminal("param1");
        param2           = new NonTerminal("param2");
        param3           = new NonTerminal("param3");
        typedIdent       = new NonTerminal("typedIden");
        cmd              = new NonTerminal("cmd");
        cmd1             = new NonTerminal("cmd1");
        cmd2             = new NonTerminal("cmd2");
        cmd3             = new NonTerminal("cmd3");
        cmd31            = new NonTerminal("cmd31");
        cmd4             = new NonTerminal("cmd4");
        cmd41            = new NonTerminal("cmd41");
        cmd5             = new NonTerminal("cmd5");
        cmd6             = new NonTerminal("cmd6");
        cmd7             = new NonTerminal("cmd7");
        cpsCmd           = new NonTerminal("cpsCmd");
        cpsCmd1          = new NonTerminal("cpsCmd1");
        cpsCmd2          = new NonTerminal("cpsCmd2");
        globInits        = new NonTerminal("globInits");
        idents           = new NonTerminal("idents");
        idents1          = new NonTerminal("idents1");
        idents2          = new NonTerminal("idents2");
        expr             = new NonTerminal("expr");
        expr1            = new NonTerminal("expr1");
        expr2            = new NonTerminal("expr2");
        term1            = new NonTerminal("term1");
        term11           = new NonTerminal("term11");
        term12           = new NonTerminal("term12");
        term2            = new NonTerminal("term2");
        term21           = new NonTerminal("term21");
        term211          = new NonTerminal("term211");
        term3            = new NonTerminal("term3");
        term31           = new NonTerminal("term31");
        term311          = new NonTerminal("term311");
        factor           = new NonTerminal("factor");
        factor1          = new NonTerminal("factor1");
        factor2          = new NonTerminal("factor2");
        factor21         = new NonTerminal("factor21");
        factor211        = new NonTerminal("factor211");
        factor3          = new NonTerminal("factor3");
        factor4          = new NonTerminal("factor4");
        factor5          = new NonTerminal("factor5");
        exprList         = new NonTerminal("exprList");
        exprList1        = new NonTerminal("exprList1");
        exprList2        = new NonTerminal("exprList2");
        exprList3        = new NonTerminal("exprList3");
        exprList4        = new NonTerminal("exprList4");
        monadicOpr       = new NonTerminal("monadicOpr");
        precondition     = new NonTerminal("precondition");
        postcondition    = new NonTerminal("postcondition");
        invariant        = new NonTerminal("invariant");
        addopr           = new NonTerminal("addopr");
        multopr          = new NonTerminal("multopr");
        relopr           = new NonTerminal("relopr");
        boolopr          = new NonTerminal("boolopr");
        atomtype         = new NonTerminal("atomtype");
        changemode       = new NonTerminal("changemode");
        mechmode         = new NonTerminal("mechmode");
        literal          = new NonTerminal("literal");
        boolVal          = new NonTerminal("boolval");
        flowmode         = new NonTerminal("flowmode");
    }
    
    public void createProgram() {
        grammar.addProduction(programNt, id , progParamList, doBlock, cpsCmd,program4,endProgram);
        grammar.addProduction(program1, invariant);
        grammar.addProduction(program1, emptyWord);
        grammar.addProduction(program2, program21);
        grammar.addProduction(program2,emptyWord);
        grammar.addProduction(program21, global, cpsDecl);
        grammar.addProduction(program3, precondition);
        grammar.addProduction(program3, emptyWord);
        grammar.addProduction(program4, postcondition);
        grammar.addProduction(program4, emptyWord);
    }
    
    private void createDeclarations() {
        grammar.addProduction(decl, stoDecl);
        grammar.addProduction(decl, funDecl);
        grammar.addProduction(decl, procDecl);
    }
    
    private void createStoDecl() {
        grammar.addProduction(stoDecl, stoDecl1, typedIdent);
        grammar.addProduction(stoDecl1, changemode);
        grammar.addProduction(stoDecl1, emptyWord);
    }
    
    private void createFunDecl() {
        grammar.addProduction(funDecl, id, paramList, returns, stoDecl, funDecl1,funDecl2, funDecl3, doBlock, cpsCmd, funDecl4, endfun);
        grammar.addProduction(funDecl1, funDecl11);
        grammar.addProduction(funDecl1, emptyWord);
        grammar.addProduction(funDecl11, global, globImps);
        grammar.addProduction(funDecl2, funDecl21);
        grammar.addProduction(funDecl2, emptyWord);
        grammar.addProduction(funDecl21, local, cpsStoDecl);
        grammar.addProduction(funDecl3, precondition);
        grammar.addProduction(funDecl3, emptyWord);
        grammar.addProduction(funDecl4, postcondition);
        grammar.addProduction(funDecl4, emptyWord);
    }
    
    private void createProdcDecl() {
        grammar.addProduction(procDecl, proc, id, paramList, procDecl1, procDecl2, procDecl3, doBlock, cpsCmd, procDecl4, endProc);
        grammar.addProduction(procDecl1, procDecl11);
        grammar.addProduction(procDecl1, emptyWord);
        grammar.addProduction(procDecl11, global, globImps);
        grammar.addProduction(procDecl2, procDecl21);
        grammar.addProduction(procDecl2, emptyWord);
        grammar.addProduction(procDecl21, local, cpsStoDecl);
        grammar.addProduction(procDecl3, precondition);
        grammar.addProduction(procDecl3, emptyWord);
        grammar.addProduction(procDecl4, postcondition);
        grammar.addProduction(procDecl4, emptyWord);
    }
    
    private void createGlobals() {
        grammar.addProduction(globImps, globImp, globImps1);
        grammar.addProduction(globImps1, globImps2, globImps1);
        grammar.addProduction(globImps1, emptyWord);
        grammar.addProduction(globImps2, comma, globImp);
        grammar.addProduction(globImp, globImp1, globImp2, id);
        grammar.addProduction(globImp1, flowmode);
        grammar.addProduction(globImp1, emptyWord);
        grammar.addProduction(globImp2, changemode);
        grammar.addProduction(globImp2, emptyWord);
    }
    
    private void createDecls() {
        grammar.addProduction(cpsDecl, decl, cpsDecl1);
        grammar.addProduction(cpsDecl1, cpsDecl2, cpsDecl1);
        grammar.addProduction(cpsDecl1, emptyWord);
        grammar.addProduction(cpsDecl2, semicolon, decl);
        grammar.addProduction(cpsStoDecl, stoDecl, cpsStoDecl1);
        grammar.addProduction(cpsStoDecl1, cpsStoDecl2, cpsStoDecl1);
        grammar.addProduction(cpsStoDecl1, emptyWord);
        grammar.addProduction(cpsStoDecl2, semicolon, stoDecl);
    }
  
    
    private void createParamList() {
        grammar.addProduction(progParamList, lparent, progParamList1, rparent);
        grammar.addProduction(progParamList1, progParamList2);
        grammar.addProduction(progParamList1, emptyWord);
        grammar.addProduction(progParamList2, progParam, progParamList3);
        grammar.addProduction(progParamList3, progParamList4, progParamList3);
        grammar.addProduction(progParamList3, emptyWord);
        grammar.addProduction(progParamList4, comma, progParam);
        grammar.addProduction(progParam, progParam1, progParam2, typedIdent);
        grammar.addProduction(progParam1, flowmode);
        grammar.addProduction(progParam1, emptyWord);
        grammar.addProduction(progParam2, changemode);
        grammar.addProduction(progParam2, emptyWord);
        grammar.addProduction(paramList, lparent, paramList1, rparent);
        grammar.addProduction(paramList1, paramList2);
        grammar.addProduction(paramList1, emptyWord);
        grammar.addProduction(paramList2, param, paramList3);
        grammar.addProduction(paramList3, paramList4, paramList3);
        grammar.addProduction(paramList3, emptyWord);
        grammar.addProduction(paramList4, comma, param);
        grammar.addProduction(param, param1, param2, param3, typedIdent);
        grammar.addProduction(param1, flowmode);
        grammar.addProduction(param1, emptyWord);
        grammar.addProduction(param2, mechmode);
        grammar.addProduction(param2, emptyWord);
        grammar.addProduction(param3, changemode);
        grammar.addProduction(param3, emptyWord);
        grammar.addProduction(typedIdent, id, colon, atomtype);
    }
    
    private void createProgramParamList() {
        grammar.addProduction(progParamList,lparent, progParamList1, rparent);
        grammar.addProduction(progParamList1,progParamList2);
        grammar.addProduction(progParamList1,emptyWord);
        grammar.addProduction(progParamList2,progParam, progParamList3);
        grammar.addProduction(progParamList3,progParamList4, progParamList3);
        grammar.addProduction(progParamList3,emptyWord);
        grammar.addProduction(progParamList4,comma, progParam);
        grammar.addProduction(progParam,progParam1, progParam2, typedIdent);
        grammar.addProduction(progParam1,flowmode);
        grammar.addProduction(progParam1,emptyWord);
        grammar.addProduction(progParam2,changemode);
        grammar.addProduction(progParam2,emptyWord);
        grammar.addProduction(paramList,lparent, paramList1, rparent);
        grammar.addProduction(paramList1, paramList2);
        grammar.addProduction(paramList1, emptyWord);
        grammar.addProduction(paramList2, param, paramList3);
        grammar.addProduction(paramList3, paramList4,paramList3);
        grammar.addProduction(paramList3, emptyWord);
        grammar.addProduction(paramList4, comma, param);
        grammar.addProduction(param, param1,param2,param3,typedIdent);
        grammar.addProduction(param1,flowmode);
        grammar.addProduction(param1,emptyWord);
        grammar.addProduction(param2,mechmode);
        grammar.addProduction(param2,emptyWord);
        grammar.addProduction(param3,changemode);
        grammar.addProduction(param3,emptyWord);
        grammar.addProduction(typedIdent, id, colon, atomtype);
    }
    
    private void createCommands() {
        grammar.addProduction(cmd,skip,cmd1, cmd2,cmd3, cmd4,cmd5, cmd6, cmd7);
        grammar.addProduction(cmd1,expr, becomes, expr); 
        grammar.addProduction(cmd2,condIf , expr, condThen, cpsCmd, condElse, cpsCmd,condEnd); 
        grammar.addProduction(cmd3,whileLoop, expr,cmd31, doBlock,cpsCmd, endWhile); 
        grammar.addProduction(cmd31,invariant);
        grammar.addProduction(cmd31,emptyWord);
        grammar.addProduction(cmd4,call, id, exprList, cmd41); 
        grammar.addProduction(cmd41,globInits);    
        grammar.addProduction(cmd41,emptyWord);
        grammar.addProduction(cmd5,debugIn, expr);  
        grammar.addProduction(cmd6,debugOut, expr); 
        grammar.addProduction(cmd7,assertCmd, expr);   
        grammar.addProduction(cpsCmd,cmd, cpsCmd1); 
        grammar.addProduction(cpsCmd1,cpsCmd2, cpsCmd1); 
        grammar.addProduction(cpsCmd1,emptyWord); 
        grammar.addProduction(cpsCmd2,semicolon, cmd); 
        grammar.addProduction(globInits,init, idents); 
        grammar.addProduction(idents,id, idents1);  
        grammar.addProduction(idents1,idents2, idents1); 
        grammar.addProduction(idents1,emptyWord);
        grammar.addProduction(idents2,comma, id); 
    }

    private void createExpressions() {
        grammar.addProduction(expr,term1,expr1); 
        grammar.addProduction(expr1,expr2, expr1); 
        grammar.addProduction(expr2,boolopr, term1); 
             
        grammar.addProduction(term1,term2, term11); 
        grammar.addProduction(term11,term12); 
        grammar.addProduction(term12,relopr, term2); 
             
        grammar.addProduction(term2,term3,term21);
        grammar.addProduction(term21,term211, term21);
        grammar.addProduction(term211,addopr, term3);
        grammar.addProduction(term3,factor, term31);
        grammar.addProduction(term31,term311, term31);
        grammar.addProduction(term31,emptyWord);
        grammar.addProduction(term311,multopr, factor);
             
        grammar.addProduction(factor,
                factor1,   
                factor2,    
                factor3,    
                factor4,    
                factor5);  
        grammar.addProduction(factor1,literal);
        grammar.addProduction(factor2,id, factor21);   
        grammar.addProduction(factor21,factor211);
        grammar.addProduction(factor21,emptyWord);     
        grammar.addProduction(factor211,id,exprList); 
        grammar.addProduction(factor3,monadicOpr, factor);
        grammar.addProduction(factor4,old, lparent, expr, rparent); 
        grammar.addProduction(factor5,lparent, expr, rparent); 
        grammar.addProduction(exprList,lparent, exprList1, rparent);
        grammar.addProduction(exprList1,exprList2);
        grammar.addProduction(exprList1,emptyWord); 
        grammar.addProduction(exprList2,expr, exprList3); 
        grammar.addProduction(exprList3,exprList4, exprList3); 
        grammar.addProduction(exprList3,emptyWord); 
        grammar.addProduction(exprList4,comma, expr);
        grammar.addProduction(monadicOpr,boolNot,addopr);
    }

    private void createDesignByContract() {
        grammar.addProduction(precondition, pre, id, colon, expr);
        grammar.addProduction(postcondition, post,id,colon,expr);
        grammar.addProduction(invariant, inv, id, colon, expr);
    }
    
    private void createPrimitives() {
        grammar.addProduction(addopr,plus);
        grammar.addProduction(addopr,minus);
        grammar.addProduction(multopr, times);
        grammar.addProduction(multopr, div);
        grammar.addProduction(multopr, mod);
        grammar.addProduction(relopr, eq);
        grammar.addProduction(relopr, ne);
        grammar.addProduction(relopr, lt);
        grammar.addProduction(relopr, gt);
        grammar.addProduction(boolopr, andOpr);
        grammar.addProduction(boolopr, orOpr);
        grammar.addProduction(boolopr, candOpr);
        grammar.addProduction(boolopr, corOpr);
        grammar.addProduction(atomtype, boolType);
        grammar.addProduction(atomtype, int32);
        grammar.addProduction(changemode, constChangeMode);
        grammar.addProduction(changemode, varChangeMode);
        grammar.addProduction(mechmode, copy);
        grammar.addProduction(mechmode, ref);
        grammar.addProduction(literal, boolVal);
        grammar.addProduction(literal, intVal);
        grammar.addProduction(boolVal, boolFalse);
        grammar.addProduction(boolVal,boolTrue);
        grammar.addProduction(flowmode, in);
        grammar.addProduction(flowmode, inout);
        grammar.addProduction(flowmode, out);
    }
    
}
