package ch.fhnw.cpib.parsing.nodes;

import java.util.LinkedHashSet;
import java.util.Set;

public final class ProductionNodeUtil {
    private ProductionNodeUtil() {
        
    }
    
    public static boolean containsEmptyWord(Set<IProductionNode> nodes) {
        for (IProductionNode node : nodes) {
            if (node instanceof IEmptyWord) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean containsNode(String name, Set<IProductionNode> nodes) {
        for (IProductionNode node : nodes) {
            if (node.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
    

    public static Set<IProductionNode> removeEmptyWord(
            Set<IProductionNode> nodes) {
        Set<IProductionNode> result = new LinkedHashSet<>(nodes);

        for (IProductionNode node : nodes) {
            if (node instanceof IEmptyWord) {
                result.remove(node);
            }
        }
        return result;
    }
}
