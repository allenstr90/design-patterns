package aem.example.java.structural.composite;

public class Book extends Resource {
    private double price;
    private String title;
    private ResourceStatus status;

    public Book(double price, String title) {
        super();
        this.price = price;
        this.title = title;
        this.status = new ResourceStatus("Book => " + title);
    }

    @Override
    public double projection() {
        System.out.println("Calculating projection of book " + title);
        return price;
    }

    @Override
    public ResourceStatus getStatus() {
        return status;
    }
}
