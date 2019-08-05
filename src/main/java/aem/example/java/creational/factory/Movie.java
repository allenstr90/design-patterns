package aem.example.java.creational.factory;

import java.util.logging.Logger;

public class Movie extends Resource {
    public Movie() {
        super(ResourceType.MOVIE);
    }

    @Override
    public void construct() {
        Logger.getLogger(Movie.class.getName()).info("Init...");
    }

}
