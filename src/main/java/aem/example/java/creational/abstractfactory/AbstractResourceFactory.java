package aem.example.java.creational.abstractfactory;

public class AbstractResourceFactory {

    private AbstractResourceFactory() {
    }

    public static Resource from(ResourceType type, Format format) {
        switch (format) {
            case DIGITAL:
                return DigitalResourceFactory.from(type);
            case DEFAULT:
                return DefaultResourceFactory.from(type);
            default:
                throw new IllegalArgumentException("The format " + format.name() + " no exists");
        }
    }
}
