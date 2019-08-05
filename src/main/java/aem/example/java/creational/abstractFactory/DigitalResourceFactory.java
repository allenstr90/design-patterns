package aem.example.java.creational.abstractFactory;

public class DigitalResourceFactory {

    public static Resource from(ResourceType type){
        switch (type) {
            case BOOK:
                return new Book(Format.DIGITAL);
            case MOVIE:
                return new Movie(Format.DIGITAL);
            default:
                throw new IllegalArgumentException("The type " + type.name() + " no exists");
        }
    }
}
