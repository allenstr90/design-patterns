package aem.example.java.structural.decorator;

public class SupportFileSystemPublish extends PublisherDecorator {

    public SupportFileSystemPublish(Publisher publisher) {
        super(publisher);
    }

    public void saveToFile(String path) {
        System.out.println("SupportFileSystemPublish: Saving to " + path + " content " + super.publish());
    }
}
