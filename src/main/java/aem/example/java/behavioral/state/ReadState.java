package aem.example.java.behavioral.state;

public class ReadState implements ResourceState {

    private static ReadState readState = new ReadState();

    private ReadState() {
    }

    public static ReadState getInstance() {
        return readState;
    }

    @Override
    public void update(IndexingContext context) {
        System.out.println("The resource has been readied");
        context.setState(WriteState.getInstance());
    }
}
