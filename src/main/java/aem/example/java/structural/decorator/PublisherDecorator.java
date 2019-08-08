package aem.example.java.structural.decorator;

public class PublisherDecorator implements Publisher {
    private Publisher publisher;

    public PublisherDecorator(Publisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public String publish() {
        return publisher.publish();
    }
}
