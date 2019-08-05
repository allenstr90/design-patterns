package aem.example.java;

import aem.example.java.creational.abstractFactory.AbstractResourceFactory;
import aem.example.java.creational.abstractFactory.Format;
import aem.example.java.creational.builder.Book;
import aem.example.java.creational.factory.Resource;
import aem.example.java.creational.factory.ResourceFactory;
import aem.example.java.creational.factory.ResourceType;
import aem.example.java.creational.singleton.BookRegistrySingleton;
import aem.example.java.structural.adapter.Movie;
import aem.example.java.structural.adapter.Publisher;

import java.util.logging.Logger;

import static aem.example.java.creational.prototype.PrototypeFactory.Prototypes;
import static aem.example.java.creational.prototype.PrototypeFactory.getInstance;

/**
 * Hello world!
 */
public class App {
    private static Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        System.out.println("Hello World!");
        logger.info("Init BookBuilder ");
        Book book = Book.builder()
                .setTitle("Builder pattern")
                .setIsbn("sdad232fddf")
                .setEdition("III")
                .setPrice(3.2)
                .build();
        System.out.println(book.toString());

        logger.info("Prototype pattern");
        try {
            String protoBook = getInstance(Prototypes.BOOK).toString();
            String protoMovie = getInstance(Prototypes.MOVIE).toString();
            System.out.println(protoBook);
            System.out.println(protoMovie);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        logger.info("Factory pattern");
        Resource resourceBook = ResourceFactory.from(ResourceType.BOOK);
        Resource resourceMovie = ResourceFactory.from(ResourceType.MOVIE);
        System.out.println(resourceBook.toString());
        System.out.println(resourceMovie.toString());

        logger.info("Abstract Factory pattern");

        aem.example.java.creational.abstractFactory.Resource digitalBook = AbstractResourceFactory.from(aem.example.java.creational.abstractFactory.ResourceType.BOOK, Format.DIGITAL);
        aem.example.java.creational.abstractFactory.Resource defaultMovie = AbstractResourceFactory.from(aem.example.java.creational.abstractFactory.ResourceType.MOVIE, Format.DEFAULT);
        System.out.println(digitalBook.toString());
        System.out.println(defaultMovie.toString());

        logger.info("Singleton pattern");
        BookRegistrySingleton.getInstance().addToRegistry("key 1", "value 1");
        BookRegistrySingleton.getInstance().addToRegistry("key 2", "value 2");
        BookRegistrySingleton.getInstance().getRegistry().forEach((s, s2) -> System.out.println(String.format("Entry with key %s and value %s ", s, s2)));

        logger.info("Adapter pattern");
        Movie movie = new Movie("II World war...");
        System.out.println(Publisher.publish(movie));
        aem.example.java.structural.adapter.Book book1 = new aem.example.java.structural.adapter.Book("Java design pattern that...");
        System.out.println(Publisher.publish(book1));
    }
}
