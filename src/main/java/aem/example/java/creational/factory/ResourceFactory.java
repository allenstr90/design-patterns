package aem.example.java.creational.factory;

public class ResourceFactory {

    public static Resource from(ResourceType type) {
        switch (type) {
            case BOOK:
                return new Book();
            case MOVIE:
                return new Movie();
            default:
                throw new IllegalArgumentException("The type " + type.name() + " no exists");
        }
    }
}
