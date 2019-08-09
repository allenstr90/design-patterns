package aem.example.java.structural.flyweight;

public class Resource {
    protected FormatType type;
    protected String content;

    public Resource(FormatType type, String content) {
        this.type = type;
        this.content = content;
    }
}
