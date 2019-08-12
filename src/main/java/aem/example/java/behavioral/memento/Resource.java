package aem.example.java.behavioral.memento;

public class Resource {
    private String name;
    private String content;

    public Resource(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public Resource setContent(String content) {
        this.content = content;
        return this;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "name='" + name + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public ResourceSnapshot snapshot() {
        return new ResourceSnapshot(this);
    }

    public void restore(ResourceSnapshot snapshot) {
        this.name = snapshot.name;
        this.content = snapshot.content;
    }

    public final class ResourceSnapshot {
        private final String name;
        private final String content;

        public ResourceSnapshot(Resource resource) {
            this.name = resource.name;
            this.content = resource.content;
        }
    }
}
