package ch.fhnw.cpib.parsing;


public abstract class Transformation implements ITransformation {
    private IGrammar grammar;
    
    public Transformation(IGrammar grammar) {
        this.grammar = grammar;
    }
    
    protected IGrammar getGrammar() {
        return this.grammar;
    }

    @Override
    public void transfer(ParserTree source, ParserTree target) {
        ITreeSearch search = getSearch();
        TreeNode node = search.search(source);
        while (node != null) {
            applyTransformation(node,source, target);
            node = search.search(source);
        }
    }
    
    protected abstract ITreeSearch getSearch();

    public abstract void applyTransformation(TreeNode node,ParserTree source, ParserTree target);
}
