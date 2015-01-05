package ch.fhnw.cpib.parsing;



public interface IAtomtype extends IConcSynNode {
    public ILiteralVal.Type getType();
    
    public String toString(String indent);
    
    
}
