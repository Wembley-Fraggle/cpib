package ch.fhnw.cpib.parsing.nodes;

import java.util.List;

public final class ProductionNodeUtil {
    private ProductionNodeUtil() {
        
    }
    
    public static String toString(List<IProductionNode> nodes) {
        StringBuilder builder = new StringBuilder();
        for(IProductionNode node : nodes) {
            builder.append(node.toString());
            builder.append(" ");
        }
        if(builder.length() > 0) {
            builder.delete(builder.length()-1, builder.length());
        }
        return builder.toString();
    }
}
