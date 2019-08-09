package aem.example.java.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class ResourceStatus {

    private String info;

    private List<ResourceStatus> statuses;

    public ResourceStatus(String info) {
        this.info = info;
        this.statuses = new ArrayList<>();
    }

    public void addStatus(ResourceStatus status) {
        statuses.add(status);
    }

    public List<ResourceStatus> getStatuses() {
        return statuses;
    }

    public String getInfo() {
        return info;
    }
}
