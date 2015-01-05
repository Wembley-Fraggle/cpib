package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.errors.GrammarError;
import ch.fhnw.cpib.lexing.IToken;

public interface IConcSyn {
    ICProgram program() throws GrammarError;
    IProgram2 program2() throws GrammarError;
    IProgram21 program21() throws GrammarError;
    IProgram3 program3() throws GrammarError;
    IProgram4 program4() throws GrammarError;
    IProgParamList progParamList() throws GrammarError;
    ICpsCmd cpsCmd() throws GrammarError;
    ICCpsDecl cpsDecl() throws GrammarError;
    IStoDecl stoDecl() throws GrammarError;
    IStoDecl1 stoDecl1() throws GrammarError;
    IFunDecl funDecl() throws GrammarError;
    IFunDecl1 funDecl1() throws GrammarError;
    IFunDecl11 funDecl11() throws GrammarError;
    IFunDecl2 funDecl2() throws GrammarError;
    IFunDecl21 funDecl21() throws GrammarError;
    IFunDecl3 funDecl3() throws GrammarError;
    IFunDecl4 funDecl4() throws GrammarError;
    IProcDecl procDecl() throws GrammarError;
    ITypedIdent typedIdent() throws GrammarError;
    IChangemode changemode() throws GrammarError;
    IParamList paramList() throws GrammarError;
    IGlobImps globImps() throws GrammarError;
    ICpsStoDecl cpsStoDecl() throws GrammarError;
    IProcDecl1 procDecl1() throws GrammarError;
    IProcDecl11 procDecl11() throws GrammarError;
    IProcDecl2 procDecl2() throws GrammarError;
    IProcDecl21 procDecl21() throws GrammarError;
    IProcDecl3 procDecl3() throws GrammarError;
    IProcDecl4 procDecl4() throws GrammarError;
    IGlobImp globImp() throws GrammarError;
    IGlobImps1 globImps1() throws GrammarError;
    IGlobImps2 globImps2() throws GrammarError;
    IGlobImp1 globImp1() throws GrammarError;
    IGlobImp2 globImp2() throws GrammarError;
    IFlowmode flowmode() throws GrammarError;
    ICDecl decl() throws GrammarError;
    ICpsDecl1 cpsDecl1() throws GrammarError;
    ICpsDecl2 cpsDecl2() throws GrammarError;
    ICpsStoDecl1 cpsStoDecl1() throws GrammarError;
    ICpsStoDecl2 cpsStoDecl2() throws GrammarError;
    IProgParamList1 progParamList1() throws GrammarError;
    IProgParamList2 progParamList2() throws GrammarError;
    IProgParam progParam() throws GrammarError;
    IProgParamList3 progParamList3() throws GrammarError;
    IProgParamList4 progParamList4() throws GrammarError;
    IProgParam1 progParam1() throws GrammarError;
    IProgParam2 progParam2() throws GrammarError;
    IParamList1 paramList1() throws GrammarError;
    IParamList2 paramList2() throws GrammarError;
    IParamList3 paramList3() throws GrammarError;
    ICParam param() throws GrammarError;
    IParamList4 paramList4() throws GrammarError;
    IParam1 param1() throws GrammarError;
    IParam2 param2() throws GrammarError;
    IParam3 param3() throws GrammarError;
    IMechmode mechmode() throws GrammarError;
    IAtomtype atomtype() throws GrammarError;
    IConcExpr expr() throws GrammarError;
    ICExprList exprList() throws GrammarError;
    ICpsCmd1 cpsCmd1() throws GrammarError;
    ICpsCmd2 cpsCmd2() throws GrammarError;
    ICCmd cmd() throws GrammarError;
    ITerm1 term1() throws GrammarError;
    IExpr1 expr1() throws GrammarError;
    IExpr2 expr2() throws GrammarError;
    IBoolopr boolopr() throws GrammarError;
    ITerm2 term2() throws GrammarError;
    ITerm12 term12() throws GrammarError;
    ITerm11 term11() throws GrammarError;
    IRelopr relopr() throws GrammarError;
    ITerm3 term3() throws GrammarError;
    ITerm21 term21() throws GrammarError;
    ITerm211 term211() throws GrammarError;
    IAddopr addopr() throws GrammarError;
    ITerm31 term31() throws GrammarError;
    ITerm311 term311() throws GrammarError;
    IMultopr multopr() throws GrammarError;
    IFactor factor() throws GrammarError;
    IFactor1 factor1() throws GrammarError;
    IFactor2 factor2() throws GrammarError;
    IFactor21 factor21() throws GrammarError;
    IFactor211 factor211() throws GrammarError;
    IFactor3 factor3() throws GrammarError;
    IFactor4 factor4() throws GrammarError;
    IFactor5 factor5() throws GrammarError;
    IMonadicOpr monadicOpr() throws GrammarError;
    IExprList1 exprList1() throws GrammarError;
    IExprList2 exprList2() throws GrammarError;
    IExprList3 exprList3() throws GrammarError;
    IExprList4 exprList4() throws GrammarError;
    ILiteralVal boolval() throws GrammarError;
    ICmd1 cmd1() throws GrammarError;
    ICmd2 cmd2() throws GrammarError;
    ICmd3 cmd3() throws GrammarError;
    ICmd31 cmd31() throws GrammarError;
    ICmd4 cmd4() throws GrammarError;
    ICmd5 cmd5() throws GrammarError;
    ICmd6 cmd6() throws GrammarError;
    ICmd7 cmd7() throws GrammarError;
    ILiteral literal() throws GrammarError;
    IPrecondition precondition() throws GrammarError;
    IPostcondition postcondition() throws GrammarError;
    IInvariant invariant() throws GrammarError;
}
