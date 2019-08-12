package aem.example.java.behavioral.strategy;

public class DiskStore implements StoreStrategy {
    @Override
    public void store() {
        System.out.println("DiskStore:store");
    }
}
