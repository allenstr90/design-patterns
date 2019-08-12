package aem.example.java.behavioral.chainresponsibility;

public class DefaultSaver implements Store {
    @Override
    public boolean store(Resource resource) {
        if (resource.getType() == ResourceType.DEFAULT) {
            System.out.println("DefaultSaver:store Saving resource type " + resource.getType().name());
            return true;
        }
        return false;
    }
}
