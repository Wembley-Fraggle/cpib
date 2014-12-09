package ch.fhnw.cpib.parsing;

import static org.mockito.Mockito.mock;
import ch.fhnw.cpib.lexing.ILexerContext;
import ch.fhnw.cpib.lexing.ITerminal;
import ch.fhnw.cpib.lexing.IToken;
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
    ITerminal var;
    ITerminal constant;
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
    ITerminal deboutIn;
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
    INonTerminal boolval;
    INonTerminal flowmode;
    
    IGrammar create() {
        emptyWord = new EmptyWord();
        createTerminals();
        createNonTerminals();
        createProgram();
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
        var = new Terminal("VAR","var");
        constant = new Terminal("CONST","const");
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
        deboutIn = new Terminal("DEBUGIN","debugin");
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
        boolval          = new NonTerminal("boolval");
        flowmode         = new NonTerminal("flowmode");
    }
    
    public void createProgram() {
        // program : PROGRAM IDENT programParamList 
        // program1 program2 program3
        // DO
        //   cpsCmd
        // program4
        // ENDPROGRAM
        grammar.addProduction(programNt, id , progParamList, doBlock, cpsCmd,program4,endProgram);
        
        // program1: invariant | <e>
        grammar.addProduction(program1, invariant);
        grammar.addProduction(program1, emptyWord);
        
        // program2 : program21 | <e>
        grammar.addProduction(program2, program21);
        grammar.addProduction(program2,emptyWord);
        
        // program21 : GLOBAL cpsDecl
        grammar.addProduction(program21, global, cpsDecl);

        // program3: precondition | <e>
        grammar.addProduction(program3, precondition);
        grammar.addProduction(program3, emptyWord);
        
        // program4: postcondition | <e>
        grammar.addProduction(program4, postcondition);
        grammar.addProduction(program4, emptyWord);
    }
    
    private void createDeclarations() {
        // decl : stoDecl | funDecl | procDecl
        grammar.addProduction(decl, stoDecl);
        grammar.addProduction(decl, funDecl);
        grammar.addProduction(decl, procDecl);
        
        createStoDecl();
        createFunDecl();
        // createProcDecl();
    }
    
    private void createStoDecl() {
        grammar.addProduction(stoDecl, stoDecl1, typedIdent);
        grammar.addProduction(stoDecl1, changemode);
        grammar.addProduction(stoDecl1, emptyWord);
    }
    
    private void createFunDecl() {
//        grammar.addProduction(fun, ident, paramList, returns, stoDecl, funDecl1,funDecl2, funDecl3, doBlock, cpsCmd, funDecl4, endfun);
//        grammar.addProduction(funDecl1, funDecl11);
//        grammar.addProduction(funDecl1, emptyWord);
//        (funDecl1,[[N funDecl11],[]]),        (* [GLOBAL globImps] *)
//        (funDecl11,[[T GLOBAL, N globImps]]), (* GLOBAL globImps *)
//        (funDecl2,[[N funDecl21],[]]),        (* [LOCAL cpsStoDecl] *)
//        (funDecl21,[[T LOCAL, N cpsStoDecl]]), (* LOCAL cpsStoDecl *)
//        (funDecl3,[[N precondition],[]]),  (* [precondition] *)
//        (funDecl4,[[N postcondition],[]]), (* [postcondition] *)

    }
}
