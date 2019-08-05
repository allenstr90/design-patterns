package aem.example.java.creational.abstractFactory;

public abstract class Resource {
    private ResourceType type;
    private Format format;

    public Resource(ResourceType type, Format format) {
        this.type = type;
        this.format = format;
    }

    public ResourceType getType() {
        return type;
    }

    public Resource setType(ResourceType type) {
        this.type = type;
        return this;
    }

    public Format getFormat() {
        return format;
    }

    public Resource setFormat(Format format) {
        this.format = format;
        return this;
    }

    public abstract void construct();

    @Override
    public String toString() {
        return String.format("Resource type %s with format %s", type.name(), format.name());
    }
}
