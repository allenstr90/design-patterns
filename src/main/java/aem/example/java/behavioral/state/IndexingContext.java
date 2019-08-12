package aem.example.java.behavioral.state;

public class IndexingContext {

    private ResourceState state;

    public IndexingContext(ResourceState state) {
        this.state = state;
    }

    public void setState(ResourceState state) {
        this.state = state;
    }

    public void update() {
        state.update(this);
    }
}
