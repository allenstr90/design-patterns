package aem.example.java.behavioral.chainresponsibility;

public class Resource {
    private ResourceType type;

    public Resource(ResourceType type) {
        this.type = type;
    }

    public ResourceType getType() {
        return type;
    }
}
