package aem.example.java.creational.prototype;

public class Movie implements PrototypeCapable {
    private String title;

    public String getTitle() {
        return title;
    }

    public Movie setTitle(String title) {
        this.title = title;
        return this;
    }

    @Override
    public PrototypeCapable clone() throws CloneNotSupportedException {
        System.out.println("Cloning movie...");
        return (Movie) super.clone();
    }

    @Override
    public String toString() {
        return Movie.class.getSimpleName();
    }
}
