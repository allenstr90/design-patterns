package aem.example.java.behavioral.strategy;

public class StoreContext {
    private StoreStrategy strategy;

    public StoreContext(StoreStrategy strategy) {
        this.strategy = strategy;
    }

    public StoreContext setStrategy(StoreStrategy strategy) {
        this.strategy = strategy;
        return this;
    }

    public void store() {
        this.strategy.store();
    }
}
