package aem.example.java.structural.facade;

public class Worker {
    private Resource resource;

    public Worker(Resource resource) {
        this.resource = resource;
    }

    public void doAnything() {
        System.out.println("Worker:doAnything with resource " + resource.getType().name());
    }
}
