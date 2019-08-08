package aem.example.java.structural.composite;

import java.util.ArrayList;
import java.util.List;

public abstract class Resource {
    protected List<Resource> resources;

    public Resource() {
        this.resources = new ArrayList<>();
    }

    public abstract double projection();

    public abstract ResourceStatus getStatus();

    public void add(Resource resource) {
        resources.add(resource);
    }
}
