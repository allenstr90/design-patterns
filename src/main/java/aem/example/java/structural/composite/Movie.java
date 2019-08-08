package aem.example.java.structural.composite;

public class Movie extends Resource {
    private ResourceStatus status;
    private double price;
    private Location location;
    private String name;

    public Movie(double price, Location location, String name) {
        super();
        this.price = price;
        this.location = location;
        this.name = name;
        this.status = new ResourceStatus(String.format("Movie %s on location %s", name, location.name()));
    }


    @Override
    public double projection() {
        System.out.println(String.format("Calculating projection if Movie %s on location %s", name, location.name()));
        return price * location.getFactor();
    }

    @Override
    public ResourceStatus getStatus() {
        return status;
    }
}
