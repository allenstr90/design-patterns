package aem.example.java.behavioral.strategy;

public class CloudStore implements StoreStrategy {
    @Override
    public void store() {
        System.out.println("CloudStore:store");
    }
}
