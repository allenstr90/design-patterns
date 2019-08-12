package aem.example.java.behavioral.chainresponsibility;

@FunctionalInterface
public interface Store {
    boolean store(Resource resource);
}
