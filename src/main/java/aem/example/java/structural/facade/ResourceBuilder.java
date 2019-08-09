package aem.example.java.structural.facade;

public class ResourceBuilder {

    public static Resource assemble(String type, String content) {
        System.out.println("ResourceBuilder:assemble build Resource from type " + type);
        return new Resource(ResourceType.valueOf(type), content);
    }
}
