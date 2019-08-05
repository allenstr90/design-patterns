package aem.example.java.creational.prototype;

import java.util.logging.Logger;

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
        Logger.getLogger(Movie.class.getName()).info("Cloning...");
        return (Movie) super.clone();
    }

    @Override
    public String toString() {
        return Movie.class.getSimpleName();
    }
}
