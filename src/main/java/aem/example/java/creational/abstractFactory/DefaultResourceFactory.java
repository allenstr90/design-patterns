package aem.example.java.creational.abstractFactory;

public class DefaultResourceFactory {

    public static Resource from(ResourceType type) {
        switch (type) {
            case BOOK:
                return new Book(Format.DEFAULT);
            case MOVIE:
                return new Movie(Format.DEFAULT);
            default:
                throw new IllegalArgumentException("The type " + type.name() + " no exists");
        }
    }
}
