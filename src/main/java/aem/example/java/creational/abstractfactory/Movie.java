package aem.example.java.creational.abstractfactory;

import java.util.logging.Logger;

public class Movie extends Resource {
    public Movie(Format format) {
        super(ResourceType.MOVIE, format);
    }

    @Override
    public void construct() {
        Logger.getLogger(Movie.class.getName()).info("Init...");
    }
}
