package aem.example.java;

import aem.example.java.behavioral.chainresponsibility.BookSaver;
import aem.example.java.behavioral.chainresponsibility.DefaultSaver;
import aem.example.java.behavioral.chainresponsibility.DigitalSaver;
import aem.example.java.behavioral.chainresponsibility.Store;
import aem.example.java.behavioral.command.ContentReader;
import aem.example.java.behavioral.command.Operation;
import aem.example.java.behavioral.command.TitleReader;
import aem.example.java.behavioral.iterator.Item;
import aem.example.java.behavioral.iterator.MyIterator;
import aem.example.java.behavioral.iterator.MyList;
import aem.example.java.behavioral.mediator.Processor;
import aem.example.java.behavioral.mediator.ProcessorPool;
import aem.example.java.behavioral.memento.Resource.ResourceSnapshot;
import aem.example.java.behavioral.observer.Observable;
import aem.example.java.behavioral.observer.Observer;
import aem.example.java.behavioral.state.IndexingContext;
import aem.example.java.behavioral.state.ReadState;
import aem.example.java.behavioral.strategy.CloudStore;
import aem.example.java.behavioral.strategy.DiskStore;
import aem.example.java.behavioral.strategy.StoreContext;
import aem.example.java.behavioral.visitor.IndexerVisitor;
import aem.example.java.behavioral.visitor.Visitable;
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

import java.util.Arrays;
import java.util.List;
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

        logger.info("Iterator pattern");
        Item[] items = new Item[]{new Item("Shoes"), new Item("T-shirt"), new Item("Phone")};
        MyList<Item> itemMyList = new MyList.MyListImpl<>(items);
        MyIterator<Item> iterator = itemMyList.iterator();
        while (iterator.hasNext()) {
            System.out.println(String.format("Current: %s, Next: %s", iterator.current().getName(), iterator.next().getName()));
        }

        logger.info("Mediator pattern");
        ProcessorPool pool = new ProcessorPool();
        Processor processor1 = new Processor("A1", pool);
        Processor processor2 = new Processor("B1", pool);
        pool.add(processor1);
        pool.add(processor2);
        processor1.send("code 1", "B1");
        processor2.send("result a", "A1");

        logger.info("Memento pattern");
        aem.example.java.behavioral.memento.Resource resource3 = new aem.example.java.behavioral.memento.Resource("A1", "In java 11...");
        System.out.println("Original state -> " + resource3.toString());
        ResourceSnapshot original = resource3.snapshot();
        resource3.setContent("Spring boot in...");
        System.out.println("Change state -> " + resource3.toString());
        resource3.restore(original);
        System.out.println("Back to original state -> " + resource3.toString());

        logger.info("Observer pattern");
        Observer observer = new Observer.MyObserver("Obs1");
        Observer observer2 = new Observer.MyObserver("Obs2");
        Observable observable = new Observable.MyObservable();
        observable.subscribe(observer);
        observable.subscribe(observer2);
        observable.notify("Hello observers");
        System.out.println("Unsubscribe observer2");
        observable.unSubscribe(observer2);
        observable.notify("Clean observers");

        logger.info("State pattern");
        IndexingContext context = new IndexingContext(ReadState.getInstance());
        context.update();
        context.update();

        logger.info("Strategy pattern");
        StoreContext storeContext = new StoreContext(() -> System.out.println("Default store strategy"));
        storeContext.store();
        storeContext.setStrategy(() -> System.out.println("Try other strategy"));
        storeContext.store();
        storeContext.setStrategy(new DiskStore());
        storeContext.store();
        storeContext.setStrategy(new CloudStore());
        storeContext.store();

        logger.info("Template pattern");
        aem.example.java.behavioral.template.Resource resource4 =
                new aem.example.java.behavioral.template.Book("Java 11", "Develop app...", 400);

        aem.example.java.behavioral.template.Resource resource5 =
                new aem.example.java.behavioral.template.Movie("Tuto 3", "In this tuto...", "Internet");

        System.out.println(resource4);
        resource4.build();
        System.out.println(resource4);

        System.out.println(resource5);
        resource5.build();
        System.out.println(resource5);

        logger.info("Visitor pattern");
        List<Visitable> visitables = Arrays.asList(new aem.example.java.behavioral.visitor.Book("Java 11"),
                new aem.example.java.behavioral.visitor.Movie("In action"),
                new aem.example.java.behavioral.visitor.Book("Spring Boot"));
        IndexerVisitor indexerVisitor = new IndexerVisitor();
        visitables.forEach(visitable -> visitable.accept(indexerVisitor));
        System.out.println(indexerVisitor.getIndexedElements());
    }
}
