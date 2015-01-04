package ch.fhnw.cpib.parsing;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExpr;

public interface ITerm1 extends IConcSynNode {

    IExpr toAbsSyn();

		String toString(String indent);

}
