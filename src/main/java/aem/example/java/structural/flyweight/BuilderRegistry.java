package aem.example.java.structural.flyweight;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class BuilderRegistry {

    private static Map<String, Builder> registry = new HashMap<>();

    private BuilderRegistry() {
    }

    public static Builder getBookBuilder(FormatType formatType) {
        String key = "BOOK-" + formatType.name();
        Optional<Builder> builder = Optional.ofNullable(registry.get(key));
        if (builder.isPresent()) {
            System.out.println("Reuse instance");
        } else {
            System.out.println("Putting the new builder");
        }
        return builder.orElse(registry.put(key, new BookBuilder(formatType)));
    }
}
