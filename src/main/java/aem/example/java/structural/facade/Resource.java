package aem.example.java.structural.facade;

public class Resource {
    private ResourceType type;
    private String content;

    public Resource(ResourceType type, String content) {
        this.type = type;
        this.content = content;
    }

    public ResourceType getType() {
        return type;
    }
}
