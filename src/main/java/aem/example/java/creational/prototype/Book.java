package aem.example.java.creational.prototype;

import java.util.logging.Logger;

public class Book implements PrototypeCapable {
    private String title;

    public String getTitle() {
        return title;
    }

    public Book setTitle(String title) {
        this.title = title;
        return this;
    }

    @Override
    public String toString() {
        return Book.class.getSimpleName();
    }

    @Override
    public PrototypeCapable clone() throws CloneNotSupportedException {
        Logger.getLogger(Book.class.getName()).info("Cloning...");
        return (Book) super.clone();
    }

}
