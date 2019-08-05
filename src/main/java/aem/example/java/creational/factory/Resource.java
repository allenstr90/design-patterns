package aem.example.java.creational.factory;

public abstract class Resource {
    private ResourceType type;

    public Resource(ResourceType type) {
        init();
        this.type = type;
    }

    public ResourceType getType() {
        return type;
    }

    public Resource setType(ResourceType type) {
        this.type = type;
        return this;
    }

    private void init() {
    }

    public abstract void construct();

    @Override
    public String toString() {
        return String.format("Resource type %s", type.name());
    }
}
