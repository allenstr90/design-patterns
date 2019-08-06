package aem.example.java.structural.bridge;

public class PublisherAbstractionImpl implements PublisherAbstraction{
    private ResourceReader resource;

    public PublisherAbstractionImpl(ResourceReader resource) {
        this.resource = resource;
    }

    public PublisherAbstractionImpl setResource(ResourceReader resource) {
        this.resource = resource;
        return this;
    }

    @Override
    public Object readContent() {
        return resource.readContent();
    }

    @Override
    public boolean store() {
        return resource.store();
    }
}
