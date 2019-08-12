package aem.example.java.behavioral.state;

public class WriteState implements ResourceState {
    private static WriteState instance = new WriteState();

    private WriteState() {
    }

    public static WriteState getInstance() {
        return instance;
    }

    @Override
    public void update(IndexingContext context) {
        System.out.println("WriteState:update");
        context.setState(getInstance());
    }
}
