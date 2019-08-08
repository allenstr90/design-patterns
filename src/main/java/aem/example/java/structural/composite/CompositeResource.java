package aem.example.java.structural.composite;

import java.util.Objects;

public class CompositeResource extends Resource {
    private ResourceStatus status;

    public CompositeResource() {
        this.status = new ResourceStatus("Composite resource status");
    }

    @Override
    public double projection() {
        return resources.stream().mapToDouble(Resource::projection).sum();
    }

    @Override
    public ResourceStatus getStatus() {
        resources.stream().filter(Objects::nonNull).forEach(resource -> status.addStatus(resource.getStatus()));
        return status;
    }
}
