package aem.example.java.structural.proxy;

public class PublisherImpl implements Publisher {
    @Override
    public void publish() {
        System.out.println("PublisherImpl:publish");
    }
}
