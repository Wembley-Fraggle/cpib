package ch.fhnw.cpib.parsing.nodes;

public class EndMarker extends AbstractProductionNode implements IEndMarker{

    public EndMarker() {
        super("<$>");
    }
}
