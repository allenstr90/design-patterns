package aem.example.java.creational.singleton;

import java.util.HashMap;
import java.util.Map;

public class BookRegistrySingleton {
    private static volatile BookRegistrySingleton singleton = null;
    private Map<String, String> registry;

    private BookRegistrySingleton() {
        this.registry = new HashMap<>();
    }

    public static BookRegistrySingleton getInstance() {
        if (singleton == null) {
            synchronized (BookRegistrySingleton.class) {
                if (singleton == null) {
                    System.out.println("Init singleton...");
                    singleton = new BookRegistrySingleton();
                }
            }
        }
        return singleton;
    }

    public void addToRegistry(String key, String value) {
        registry.put(key, value);
    }

    public Map<String, String> getRegistry() {
        return registry;
    }
}
