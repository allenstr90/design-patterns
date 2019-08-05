package aem.example.java.creational.factory;

import java.util.logging.Logger;

public class Book extends Resource {

    public Book() {
        super(ResourceType.BOOK);
    }

    @Override
    public void construct() {
        Logger.getLogger(Book.class.getName()).info("Init...");
    }
}
