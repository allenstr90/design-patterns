package aem.example.java.structural.facade;

import java.util.Arrays;

public class IndexerFacade {

    private IndexerFacade() {
    }

    public static void indexResource(String type, String content) {
        System.out.println(String.format("Finding resource type %s and assemble and work with resource content %s", type, content));
        ResourceType resourceType = Arrays.stream(ResourceType.values())
                .parallel()
                .filter(resourceType1 -> resourceType1.name().equalsIgnoreCase(type))
                .findAny()
                .orElse(ResourceType.DEFAULT);
        Resource resource = ResourceBuilder.assemble(resourceType.name().toUpperCase(), content);
        Worker worker = new Worker(resource);
        worker.doAnything();
    }
}
