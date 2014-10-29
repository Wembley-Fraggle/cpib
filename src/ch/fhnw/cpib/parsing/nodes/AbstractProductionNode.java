package ch.fhnw.cpib.parsing.nodes;

public abstract class AbstractProductionNode implements IProductionNode {

    private String name;
    
    public AbstractProductionNode(String name) {
        if (name == null || name.length() == 0) {
            throw new IllegalArgumentException("name must not be null or empty");
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + getClass().hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        AbstractProductionNode other = (AbstractProductionNode) obj;
        return name.equals(other.name);
    }
    
    public String toString() {
        return name;
    }
    
}
