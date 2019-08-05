package aem.example.java.creational.abstractFactory;

import java.util.logging.Logger;

public class Book extends Resource {

    public Book(Format format) {
        super(ResourceType.BOOK, format);
    }

    @Override
    public void construct() {
        Logger.getLogger(Book.class.getName()).info("Init...");
    }
}
