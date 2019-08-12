package aem.example.java;

import aem.example.java.behavioral.chainresponsibility.BookSaver;
import aem.example.java.behavioral.chainresponsibility.DefaultSaver;
import aem.example.java.behavioral.chainresponsibility.DigitalSaver;
import aem.example.java.behavioral.chainresponsibility.Store;
import aem.example.java.behavioral.command.ContentReader;
import aem.example.java.behavioral.command.Operation;
import aem.example.java.behavioral.command.TitleReader;
import aem.example.java.creational.abstractfactory.AbstractResourceFactory;
import aem.example.java.creational.abstractfactory.Format;
import aem.example.java.creational.builder.Book;
import aem.example.java.creational.factory.Resource;
import aem.example.java.creational.factory.ResourceFactory;
import aem.example.java.creational.factory.ResourceType;
import aem.example.java.creational.singleton.BookRegistrySingleton;
import aem.example.java.structural.adapter.Movie;
import aem.example.java.structural.adapter.Publisher;
import aem.example.java.structural.bridge.*;
import aem.example.java.structural.composite.CompositeResource;
import aem.example.java.structural.composite.Location;
import aem.example.java.structural.decorator.BookPublisher;
import aem.example.java.structural.decorator.SupportFileSystemPublish;
import aem.example.java.structural.facade.IndexerFacade;
import aem.example.java.structural.flyweight.BuilderRegistry;
import aem.example.java.structural.flyweight.FormatType;
import aem.example.java.structural.proxy.ProxyPublisher;

import java.util.logging.Level;
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
            logger.log(Level.SEVERE, e.getMessage(), e);
        }

        logger.info("Factory pattern");
        Resource resourceBook = ResourceFactory.from(ResourceType.BOOK);
        Resource resourceMovie = ResourceFactory.from(ResourceType.MOVIE);
        System.out.println(resourceBook.toString());
        System.out.println(resourceMovie.toString());

        logger.info("Abstract Factory pattern");

        aem.example.java.creational.abstractfactory.Resource digitalBook = AbstractResourceFactory.from(aem.example.java.creational.abstractfactory.ResourceType.BOOK, Format.DIGITAL);
        aem.example.java.creational.abstractfactory.Resource defaultMovie = AbstractResourceFactory.from(aem.example.java.creational.abstractfactory.ResourceType.MOVIE, Format.DEFAULT);
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

        logger.info("Bridge pattern...");
        aem.example.java.structural.bridge.Book book2 = new aem.example.java.structural.bridge.Book("Java pattern for real life");
        aem.example.java.structural.bridge.Movie movie1 = new aem.example.java.structural.bridge.Movie("Java 11 in real life".getBytes());
        ResourceReader bookReader = new BookReader(book2);
        ResourceReader movieReader = new MovieReader(movie1);

        PublisherAbstraction publisherBook = new PublisherAbstractionImpl(bookReader);
        PublisherAbstraction publisherMovie = new PublisherAbstractionImpl(movieReader);
        System.out.println(String.format("Read content %s with store %s", publisherBook.readContent(), publisherBook.store()));
        System.out.println(String.format("Read content %s with store %s", new String((byte[]) publisherMovie.readContent()), publisherMovie.store()));

        logger.info("Composite pattern");
        aem.example.java.structural.composite.Resource resource = new CompositeResource();
        resource.add(new aem.example.java.structural.composite.Movie(1.0, Location.INTERNET, "Java in action"));
        resource.add(new aem.example.java.structural.composite.Book(1.0, "Spring tutorial"));
        System.out.println(String.format("The projection is %f", resource.projection()));

        logger.info("Decorator pattern");
        aem.example.java.structural.decorator.Book book3 = new aem.example.java.structural.decorator.Book("New in java 11");
        aem.example.java.structural.decorator.Publisher publisher = new BookPublisher(book3);
        aem.example.java.structural.decorator.Publisher publisherFileSystem = new SupportFileSystemPublish(publisher);
        ((SupportFileSystemPublish) publisherFileSystem).saveToFile("/home/myPath");

        logger.info("Facade pattern");
        IndexerFacade.indexResource("digital", "Java tutorial");
        IndexerFacade.indexResource("other", "Other content");

        logger.info("Flyweight pattern");
        BuilderRegistry.getBookBuilder(FormatType.DIGITAL);
        BuilderRegistry.getBookBuilder(FormatType.DIGITAL);

        logger.info("Proxy pattern");
        aem.example.java.structural.proxy.Publisher proxy = new ProxyPublisher();
        proxy.publish();

        logger.info("Chain of Responsibility pattern");
        aem.example.java.behavioral.chainresponsibility.Resource resource1 = new aem.example.java.behavioral.chainresponsibility.Resource(aem.example.java.behavioral.chainresponsibility.ResourceType.DIGITAL);
        aem.example.java.behavioral.chainresponsibility.Resource resource2 = new aem.example.java.behavioral.chainresponsibility.Resource(aem.example.java.behavioral.chainresponsibility.ResourceType.DEFAULT);
        Store managerStore = new BookSaver();
        // config
        Store defaultStore = new DefaultSaver();
        Store digitalStore = new DigitalSaver(defaultStore);
        ((BookSaver) managerStore).setNextStore(digitalStore);
        // end config
        managerStore.store(resource1);
        managerStore.store(resource2);

        logger.info("Command pattern");
        aem.example.java.behavioral.command.Book book4 = new aem.example.java.behavioral.command.Book("Command book", "Inthe command pattern...");
        Operation titleRead = new TitleReader(book4);
        Operation contentRead = new ContentReader(book4);
        titleRead.execute();
        contentRead.execute();
    }
}
