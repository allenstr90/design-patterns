package aem.example.java.creational.prototype;

import java.util.Map;

public class PrototypeFactory {
    private static Map<Prototypes, PrototypeCapable> registry = Map.of(
            Prototypes.BOOK, new Book(), Prototypes.MOVIE, new Movie()
    );

    public static PrototypeCapable getInstance(Prototypes prototypes) throws CloneNotSupportedException {
        return registry.get(prototypes).clone();
    }

    public enum Prototypes {
        BOOK, MOVIE
    }

}
