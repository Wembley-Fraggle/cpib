datatype term
  = LPAREN
  | RPAREN
  | COMMA
  | SEMICOLON
  | COLON
  | BECOMES
  | MULTOPR_TIMES
  | MULTOPR_DIV
  | MULTOPR_MOD
  | ADDOPR_PLUS
  | ADDOPR_MINUS
  | RELOPR_EQ
  | RELOPR_NE
  | RELOPR_LT
  | RELOPR_GT
  | RELOPR_LE
  | RELOPR_GE
  | BOOLOPR_AND
  | BOOLOPR_OR
  | BOOLOPR_CAND
  | BOOLOPR_COR
  | TYPE_BOOL
  | TYPE_INT32
  | CALL
  | CHANGEMODE_CONST
  | CHANGEMODE_VAR
  | MECHMODE_COPY
  | MECHMODE_REF
  | DEBUGIN
  | DEBUGOUT
  | DO
  | ELSE
  | ENDFUN
  | ENDIF
  | ENDPROC
  | ENDPROGRAM
  | ENDWHILE
  | LITERAL_BOOLVAL_FALSE
  | LITERAL_BOOLVAL_TRUE
  | LITERAL_INTVAL32
  | FUN
  | GLOBAL
  | IF
  | FLOWMODE_IN
  | FLOWMODE_INOUT
  | FLOWMODE_OUT
  | INIT
  | LOCAL
  | NOT
  | PROC
  | PROGRAM
  | RETURNS
  | SKIP
  | THEN
  | WHILE
  | IDENT
  | ASSERT
  | PRE
  | POST
  | INV
  | OLD
  
val string_of_term =
 fn LPAREN                => "LPARENT" 
  | RPAREN                => "RPARENT"
  | COMMA                 => "COMMA"
  | SEMICOLON             => "SEMI"
  | COLON                 => "COLON"
  | BECOMES               => "BECOMES"
  | MULTOPR_TIMES         => "TIMES"
  | MULTOPR_DIV           => "DIV"
  | MULTOPR_MOD           => "MOD"
  | ADDOPR_PLUS           => "PLUS"
  | ADDOPR_MINUS          => "MINUS"
  | RELOPR_EQ             => "EQ"
  | RELOPR_NE             => "NE"
  | RELOPR_LT             => "LT"
  | RELOPR_GT             => "GT"
  | RELOPR_LE             => "LE"
  | RELOPR_GE             => "GE"
  | BOOLOPR_AND           => "AND"
  | BOOLOPR_OR            => "OR"
  | BOOLOPR_CAND          => "CAND"
  | BOOLOPR_COR           => "COR"
  | TYPE_BOOL             => "BOOL"
  | TYPE_INT32            => "INT32"
  | CALL                  => "CALL"
  | CHANGEMODE_CONST      => "CONST"
  | CHANGEMODE_VAR        => "VAR"
  | MECHMODE_COPY         => "COPY"
  | MECHMODE_REF          => "REF"
  | DEBUGIN               => "DEBUGIN"
  | DEBUGOUT              => "DEBUGOUT"
  | DO                    => "DO"
  | ELSE                  => "ELSE"
  | ENDFUN                => "ENDFUN"
  | ENDIF                 => "ENDIF"
  | ENDPROC               => "ENDPROC"
  | ENDPROGRAM            => "ENDPROGRAM"
  | ENDWHILE              => "ENDWHILE"
  | LITERAL_BOOLVAL_FALSE => "FALSE"
  | LITERAL_BOOLVAL_TRUE  => "TRUE"
  | LITERAL_INTVAL32      => "INTVAL32"
  | FUN                   => "FUN"
  | GLOBAL                => "GLOBAL"
  | IF                    => "IF"
  | FLOWMODE_IN           => "IN"
  | FLOWMODE_INOUT        => "INOUT"
  | FLOWMODE_OUT          => "OUT"
  | INIT                  => "INIT"
  | LOCAL                 => "LOCAL"
  | NOT                   => "NOT"
  | PROC                  => "PROC"
  | PROGRAM               => "PROGRAM"
  | RETURNS               => "RETURNS"
  | SKIP                  => "SKIP"
  | THEN                  => "THEN"
  | WHILE                 => "WHILE"
  | IDENT                 => "IDENT"
  | ASSERT                => "ASSERT"
  | PRE                   => "PRE"
  | POST                  => "POST"
  | INV                   => "INV"
  | OLD                   => "OLD"

datatype nonterm
  = program
  | program2
  | program21
  | program3
  | program4
  | progParamList
  | cpsCmd
  | cpsDecl
  | stoDecl
  | stoDecl1
  | funDecl
  | funDecl1
  | funDecl11
  | funDecl2
  | funDecl21
  | funDecl3
  | funDecl4
  | funDecl41
  | funDecl5
  | funDecl51
  | procDecl
  | typedIdent
  | changemode
  | paramList
  | globImps
  | cpsStoDecl
  | procDecl1
  | procDecl11
  | procDecl2
  | procDecl21
  | procDecl3
  | procDecl4
  | globImp
  | globImps1
  | globImps2
  | globImp1
  | globImp2
  | flowmode
  | decl
  | cpsDecl1
  | cpsDecl2
  | cpsStoDecl1
  | cpsStoDecl2
  | progParamList1
  | progParamList2
  | progParam
  | progParamList3
  | progParamList4
  | progParam1
  | progParam2
  | paramList1
  | paramList2
  | paramList3
  | param
  | paramList4
  | param1
  | param2
  | param3
  | mechmode
  | atomtype
  | expr
  | exprList
  | cpsCmd1
  | cpsCmd2
  | cmd
  | term1
  | expr1
  | expr2
  | boolopr
  | term2
  | term12
  | term11
  | relopr
  | term3
  | term21
  | term211
  | addopr
  | term31
  | term311
  | multopr
  | factor
  | factor1
  | factor2
  | factor21
  | factor211
  | factor3
  | factor4
  | factor5
  | monadicOpr
  | exprList1
  | exprList2
  | exprList3
  | exprList4
  | boolval
  | cmd1
  | cmd2
  | cmd3
  | cmd31
  | cmd4
  | cmd5
  | cmd6
  | cmd7
  | literal
  | precondition
  | postcondition
  | invariant
  
val string_of_nonterm =
  fn program       => "program"
  | program2       => "program2"
  | program21      => "program21"
  | program3       => "program3"
  | program4       => "program4"
  | progParamList  => "progParamList"
  | cpsCmd         => "cpsCmd"
  | stoDecl        => "stoDecl"
  | stoDecl1       => "stoDecl1"
  | procDecl       => "procDecl"
  | typedIdent     => "typedIdent"
  | changemode     => "changemode"
  | paramList      => "paramList"
  | funDecl        => "funDecl"
  | funDecl1       => "funDecl1"
  | funDecl11      => "funDecl11"
  | funDecl2       => "funDecl2"
  | funDecl21      => "funDecl21"
  | funDecl3       => "funDecl3"
  | funDecl4       => "funDecl4"
  | funDecl41      => "funDecl41"
  | funDecl5       => "funDecl5"
  | funDecl51      => "funDecl51"
  | globImps       => "globImps"
  | cpsStoDecl     => "cpsStoDecl"
  | procDecl1      => "procDecl1"
  | procDecl11     => "procDecl11"
  | procDecl2      => "procDecl2"
  | procDecl21     => "procDecl21"
  | procDecl3      => "procDecl3"
  | procDecl4      => "procDecl4"
  | globImp        => "globImp"
  | globImps1      => "globImps1"
  | globImps2      => "globImps2"
  | globImp1       => "globImp1"
  | globImp2       => "globImp2"
  | flowmode       => "flowmode"
  | decl           => "decl"
  | cpsDecl        => "cpsDecl"
  | cpsDecl1       => "cpsDecl1"
  | cpsDecl2       => "cpsDecl2"
  | cpsStoDecl1    => "cpsStoDecl1"
  | cpsStoDecl2    => "cpsStoDecl2"
  | progParamList1 => "progParamList1"
  | progParamList2 => "progParamList2"
  | progParam      => "progParam"
  | progParamList3 => "progParamList3"
  | progParamList4 => "progParamList4"
  | progParam1     => "progParam1"
  | progParam2     => "progParam2"
  | paramList1     => "paramList1"
  | paramList2     => "paramList2"
  | paramList3     => "paramList3"
  | param          => "param"
  | paramList4     => "paramList4"
  | param1         => "param1"
  | param2         => "param2"
  | param3         => "param3"
  | mechmode       => "mechmode"
  | atomtype       => "atomtype"
  | expr           => "expr"
  | exprList       => "exprList"
  | cpsCmd1        => "cpsCmd1"
  | cpsCmd2        => "cpsCmd2"
  | term1          => "term1"
  | expr1          => "expr1"
  | expr2          => "expr2"
  | boolopr        => "boolopr"
  | term2          => "term2"
  | term12         => "term12"
  | term11         => "term11"
  | relopr         => "relopr"
  | term3          => "term3"
  | term21         => "term21"
  | term211        => "term211"
  | addopr         => "addopr"
  | factor         => "factor"
  | term31         => "term31"
  | term311        => "term311"
  | multopr        => "multopr"
  | factor1        => "factor1"
  | factor2        => "factor2"
  | factor3        => "factor3"
  | factor4        => "factor4"
  | factor5        => "factor5"
  | factor21       => "factor21"
  | factor211      => "factor211"
  | monadicOpr     => "monadicOpr"
  | exprList1      => "exprList1"
  | exprList2      => "exprList2"
  | exprList3      => "exprList3"
  | exprList4      => "exprList4"
  | boolval        => "boolval"
  | cmd            => "cmd"
  | cmd1           => "cmd1"
  | cmd2           => "cmd2"
  | cmd3           => "cmd3"
  | cmd31          => "cmd31"
  | cmd4           => "cmd4"
  | cmd5           => "cmd5"
  | cmd6           => "cmd6"
  | cmd7           => "cmd7"
  | literal        => "literal"
  | precondition   => "precondition"
  | postcondition  => "postcondition"
  | invariant      => "invariant"
  
val string_of_gramsym = (string_of_term, string_of_nonterm)

local
  open FixFoxi.FixFoxiCore
in

val productions =
[
(*---------------------------------------------------------------
 * Programs:
 * ---------
 * program ::= PROGRAM IDENT progParamList
 *             [GLOBAL cpsDecl]
 *             [precondition]
 *             DO
 *               cpsCmd
 *             [postcondition]
 *             ENDPROGRAM
 *---------------------------------------------------------------
 *)
(program,[[T PROGRAM, T IDENT, N progParamList,
          N program2,                      (* [GLOBAL cpsDecl] *)
          N program3,                      (* [precondition] *)
          T DO,
          N cpsCmd,
          N program4,                      (* [postcondition] *)
          T ENDPROGRAM]
         ]),
(program2,[[N program21],[]]), (* [GLOBAL cpsDecl] *)
(program21,[[T GLOBAL, N cpsDecl]]), (* GLOBAL cpsDecl *)
(program3,[[N precondition],[]]), (* [precondition] *)
(program4,[[N postcondition],[]]), (* [postcondition] *)

(*---------------------------------------------------------------
 * Declarations:
 * -------------
 * decl         ::= stoDecl | funDecl | procDecl
 * stoDecl      ::= [changemode] typedIdent
 * funDecl      ::= FUN IDENT paramList
 *                  RETURNS stoDecl
 *                  [GLOBAL globImps]
 *                  [LOCAL cpsStoDecl]
 *                  [precondition]
 *                  DO
 *                    cpsCmd
 *                  [postcondition]
 *                  ENDFUN
 * procDecl     ::= PROC IDENT paramList
 *                  [GLOBAL globImps]
 *                  [LOCAL cpsStoDecl]
 *                  [precondition]
 *                  DO
 *                    cpsCmd
 *                  [postcondition]
 *                  ENDPROC
 * globImps     ::= globImp {COMMA globImp}
 * globImp      ::= [flowmode] [changemode] IDENT
 * cpsDecl      ::= decl {SEMICOLON decl}
 * cpsStoDecl   ::= stoDecl {SEMICOLON stoDecl}
 *---------------------------------------------------------------
 *)
 
(* stoDecl | funDecl | procDecl *)
(decl,[[N stoDecl],[N funDecl],[N procDecl]]), 

(* [changemode] typedIdent *)
(stoDecl,[[N stoDecl1,N typedIdent]]), 
(stoDecl1,[[N changemode],[]]), (* [changemode] *)

(* FUN IDENT paramList
 * RETURNS stoDecl
 * [GLOBAL globImps]
 * [LOCAL cpsStoDecl]
 * [precondition]
 * DO
 *   cpsCmd
 * [postcondition]
 * ENDFUN
 *)
(funDecl,[[T FUN, T IDENT, N paramList,
           T RETURNS, N stoDecl,
           N funDecl1,                    (* [GLOBAL globImps] *)
           N funDecl2,                    (* [LOCAL cpsStoDecl] *)
           N funDecl3,                    (* [precondition] *)
           T DO, N cpsCmd,
           N funDecl4,                    (* [postcondition] *)
           T ENDFUN]]),
(funDecl1,[[N funDecl11],[]]),        (* [GLOBAL globImps] *)
(funDecl11,[[T GLOBAL, N globImps]]), (* GLOBAL globImps *)
(funDecl2,[[N funDecl21],[]]),        (* [LOCAL cpsStoDecl] *)
(funDecl21,[[T LOCAL, N cpsStoDecl]]), (* LOCAL cpsStoDecl *)
(funDecl3,[[N precondition],[]]),  (* [precondition] *)
(funDecl4,[[N postcondition],[]]), (* [postcondition] *)

(* PROC IDENT paramList
 * [GLOBAL globImps]
 * [LOCAL cpsStoDecl]
 * [precondition]
 * DO
 *   cpsCmd
 * [postcondition]
 * ENDPROC
 *)        
(procDecl,[[T PROC, T IDENT, N paramList, 
            N procDecl1, (* [GLOBAL globImps] *) 
            N procDecl2, (* [LOCAL cpsStoDecl] *)
            N procDecl3, (* [precondition] *)
            T DO, N cpsCmd,
            N procDecl4, (* [postcondition] *)
            T ENDPROC]]),
(procDecl1,[[N procDecl11],[]]),
(procDecl11,[[T GLOBAL, N globImps]]),
(procDecl2,[[N procDecl21],[]]),
(procDecl21,[[T LOCAL, N cpsStoDecl]]),
(procDecl3,[[N precondition],[]]),
(procDecl4,[[N postcondition],[]]),

(* globImps     ::= globImp {COMMA globImp} *)
(globImps,[[N globImp, N globImps1]]),
(globImps1,[[N globImps2, N globImps1],[]]),
(globImps2,[[T COMMA, N globImp]]),

(* globImp ::= [flowmode] [changemode] IDENT *)
(globImp,[[N globImp1,N globImp2,T IDENT]]),
(globImp1,[[N flowmode],[]]),
(globImp2,[[N changemode],[]]),

(* cpsDecl ::= decl {SEMICOLON decl} *)
(cpsDecl,[[N decl,N cpsDecl1]]),
(cpsDecl1,[[N cpsDecl2, N cpsDecl1],[]]),
(cpsDecl2,[[T SEMICOLON, N decl]]),

(* cpsStoDecl ::= stoDecl {SEMICOLON stoDecl} *)
(cpsStoDecl,[[N stoDecl,N cpsStoDecl1]]),
(cpsStoDecl1,[[N cpsStoDecl2, N cpsStoDecl1],[]]),
(cpsStoDecl2, [[T SEMICOLON, N stoDecl]]),

(*---------------------------------------------------------------
 * Parameter Lists:
 * ----------------
 * progParamList ::= LPAREN [progParam {COMMA progParam}] RPAREN
 * progParam     ::= [flowmode] [changemode] typedIdent
 * paramList     ::= LPAREN [param {COMMA param}] RPAREN
 * param         ::= [flowmode] [mechmode] [changemode]
 *                   typedIdent
 * typedIdent    ::= IDENT COLON atomtype
 *---------------------------------------------------------------
 *)
 (progParamList,[[T LPAREN, N progParamList1, T RPAREN]]),
 (progParamList1,[[N progParamList2],[]]),
 (progParamList2,[[N progParam, N progParamList3]]),
 (progParamList3,[[N progParamList4, N progParamList3],[]]),
 (progParamList4,[[T COMMA, N progParam]]),
 
 (progParam,[[N progParam1, N progParam2, N typedIdent]]),
 (progParam1,[[N flowmode],[]]),
 (progParam2,[[N changemode],[]]),
 
 (* LPAREN [param {COMMA param}] RPAREN *)
 (paramList,[[T LPAREN, N paramList1, T RPAREN]]),
 (paramList1, [[N paramList2],[]]),
 (paramList2, [[N param, N paramList3]]),
 (paramList3, [[N paramList4,N paramList3], []]),
 (paramList4, [[T COMMA, N param]]),
 
 (param, [[N param1,N param2,N param3,N typedIdent]]),
 (param1,[[N flowmode], []]),
 (param2,[[N mechmode], []]),
 (param3,[[N changemode],[]]),
  
 (typedIdent, [[T IDENT, T COLON, N atomtype]]),
 
(*---------------------------------------------------------------
 * Commands:
 * ---------
 * cmd          ::= SKIP
 *                | expr BECOMES expr
 *                | IF expr THEN cpsCmd ELSE cpsCmd ENDIF
 *                | WHILE expr [invariant] DO cpsCmd ENDWHILE
 *                | CALL IDENT exprList
 *                | DEBUGIN expr
 *                | DEBUGOUT expr
 *                | ASSERT expr
 * cpsCmd       ::= cmd {SEMICOLON cmd}
 *---------------------------------------------------------------
 *)
 (cmd,[[T SKIP],
      [N cmd1], (* expr BECOMES expr *)
      [N cmd2], (* IF expr THEN cpsCmd ELSE cpsCmd ENDIF *)
      [N cmd3], (* WHILE expr [invariant] DO cpsCmd ENDWHILE *)
      [N cmd4], (* CALL IDENT exprList*)
      [N cmd5], (* DEBUGIN expr *)
      [N cmd6], (* DEBUGOUT expr *) 
      [N cmd7]] (* ASSERT expr *)
 ),
      
 (cmd1,[[N expr, T BECOMES, N expr]]), (* expr BECOMES expr *)
 
 (* IF expr THEN cpsCmd ELSE cpsCmd ENDIF *)
 (cmd2,[[T IF, N expr, T THEN, N cpsCmd, T ELSE, N cpsCmd,
         T ENDIF]]), 

 (* WHILE expr [invariant] DO cpsCmd ENDWHILE *)         
 (cmd3,[[T WHILE, N expr,N cmd31, T DO,N cpsCmd, T ENDWHILE]]), 
 (cmd31,[[N invariant],[]]), (* [invariant] *)
 
 (* CALL IDENT exprList*)
 (cmd4,[[T CALL, T IDENT, N exprList]]), 
 (cmd5,[[T DEBUGIN, N expr]]),  (* DEBUGIN expr *)
 (cmd6,[[T DEBUGOUT, N expr]]), (* DEBUGOUT expr *)
 (cmd7,[[T ASSERT, N expr]]),   (* ASSERT expr *)
 
 (cpsCmd,[[N cmd, N cpsCmd1]]), (* cmd {SEMICOLON cmd} *)
 (cpsCmd1,[[N cpsCmd2, N cpsCmd1],[]]), (* {SEMICOLON cmd} *)
 (cpsCmd2,[[T SEMICOLON, N cmd]]), (* SEMICOLON cmd *)

(*---------------------------------------------------------------
 * Expressions
 * -----------
 * expr         ::= term1 {boolopr term1}
 * term1        ::= term2 [relopr term2]
 * term2        ::= term3 {addopr term3}
 * term3        ::= factor {multopr factor}
 * factor       ::= LITERAL
 *               |  IDENT [INIT | exprList]
 *               |  monadicOpr factor
 *               |  OLD LPAREN expr RPAREN
 *               |  LPAREN expr RPAREN
 * exprList     ::= LPAREN [expr {COMMA expr}] RPAREN
 * monadicOpr   ::= NOT | addopr
 *---------------------------------------------------------------
 *)
 (expr,[[N term1,N expr1]]), (* term1 {boolopr term1} *)
 (expr1,[[N expr2, N expr1],[]]), (* {boolopr term1} *)
 (expr2,[[N boolopr, N term1]]), (* boolopr term1 *)
 
 (term1,[[N term2, N term11]]), (* term2 [relopr term2] *)
 (term11,[[N term12],[]]), (* [relopr term2] *)
 (term12,[[N relopr, N term2]]), (* relopr term2 *)
 
 (term2,[[N term3,N term21]]),(* term3 {addopr term3} *)
 (term21,[[N term211, N term21],[]]),(* {addopr term3} *)
 (term211,[[N addopr, N term3]]),(* addopr term3 *)
 
 (* factor {multopr factor} *)
 (term3,[[N factor, N term31]]),
 (term31,[[N term311, N term31],[]]),(* {multopr factor} *)
 (term311,[[N multopr, N factor]]),
 
 (* LITERAL | IDENT [INIT | exprList] | monadicOpr factor |
    OLD LPAREN expr RPAREN | LPAREN expr RPAREN *)
 (factor,
    [[N factor1],   (* LITERAL *)
    [N factor2],    (* IDENT [INIT | exprList] *)
    [N factor3],    (* monadicOpr factor*)
    [N factor4],    (* OLD LPAREN expr RPAREN *)
    [N factor5]]),  (* LPAREN expr RPAREN *)
 
 (factor1,[[N literal]]),
 (factor2,[[T IDENT, N factor21]]),   (* IDENT [INIT | exprList] *)
 (factor21,[[N factor211],[]]),       (* [INIT | exprList] *)
 (factor211,[[T INIT],[N exprList]]), (* INIT | exprList *)
 (factor3,[[N monadicOpr, N factor]]),(* monadicOpr factor *)
 (factor4,[[T OLD, T LPAREN, N expr, T RPAREN]]), (* OLD LPAREN expr RPAREN *)
 (factor5,[[T LPAREN, N expr, T RPAREN]]), (* LPAREN expr RPAREN *)
 
 (* LPAREN [expr {COMMA expr}] RPAREN *)
 (exprList,[[T LPAREN, N exprList1, T RPAREN]]),
 (exprList1,[[N exprList2],[]]), (* [expr {COMMA expr}] *)
 (exprList2,[[N expr, N exprList3]]), (* expr {COMMA expr} *)
 (exprList3,[[N exprList4, N exprList3],[]]), (* {COMMA expr} *)
 (exprList4,[[T COMMA, N expr]]),(* COMMA expr *)
 
 (* NOT | addopr *)
 (monadicOpr,[[T NOT],[N addopr]]),
 
(*---------------------------------------------------------------
 * Design by Contract
 * ------------------
 * precondition ::= PRE IDENT COLON expr
 * postcondition ::= POST IDENT COLON expr
 * invariant     ::= INV IDENT COLON expr
 *)
 (precondition,[[T PRE,T IDENT, T COLON, N expr]]),
 (postcondition,[[T POST,T IDENT, T COLON, N expr]]),
 (invariant,[[T INV,T IDENT, T COLON, N expr]]),
 
(*---------------------------------------------------------------
 * Composits:
 * ----------
 * addopr      ::= ADDOPR_PLUS | ADDOPR_MINUS
 * multopr     ::= MULTOPR_TIMES | MULTOPR_DIV | MULTOPR_MOD
 * relopr      ::= RELOPR_EQ | RELOPR_NE | RELOPR_LT | RELOPR_GT 
 *               | RELOPR_LE | RELOPR_GE
 * boolopr     ::= BOOLOPR_AND | BOOLOPR_OR | BOOLOPR_CAND
 *               | BOOLOPR_COR
 * atomtype    ::= TYPE_BOOL | TYPE_INT32
 * changemode  ::= CHANGEMODE_CONST | CHANGEMODE_VAR
 * mechmode    ::= MECHMODE_COPY | MECHMODE_REF
 * literal     ::= boolval | LITERAL_INTVAL32
 * boolval     ::= LITERAL_BOOLVAL_FALSE | LITERAL_BOOLVAL_TRUE
 * flowmode    ::= FLOWMODE_IN | FLOWMODE_INOUT | FLOWMODE_OUT
 *---------------------------------------------------------------
 *)
(addopr,[[T ADDOPR_PLUS],[T ADDOPR_MINUS]]),
(multopr,[[T MULTOPR_TIMES],[T MULTOPR_DIV],[T MULTOPR_MOD]]),
(relopr,[[T RELOPR_EQ],[T RELOPR_NE],[T RELOPR_LT],
         [T RELOPR_GT],[T RELOPR_LE],[T RELOPR_GE]]),
(boolopr,[[T BOOLOPR_AND], [T BOOLOPR_OR], [T BOOLOPR_CAND],
          [T BOOLOPR_COR] ]),
(atomtype,[[T TYPE_BOOL],[T TYPE_INT32]]),
(changemode,[[T CHANGEMODE_CONST],[T CHANGEMODE_VAR]]),
(mechmode,[[T MECHMODE_COPY],[T MECHMODE_REF]]),
(literal,[[N boolval], [T LITERAL_INTVAL32]]),
(boolval,[[T LITERAL_BOOLVAL_FALSE],[T LITERAL_BOOLVAL_TRUE]]),
(flowmode,[[T FLOWMODE_IN],[T FLOWMODE_INOUT],[T FLOWMODE_OUT]])
]
 
val S = program

val result = fix_foxi productions S string_of_gramsym

end (* local *)
