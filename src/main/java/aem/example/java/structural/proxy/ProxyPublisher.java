package aem.example.java.structural.proxy;

public class ProxyPublisher extends PublisherImpl {
    @Override
    public void publish() {
        System.out.println("ProxyPublisher:publish");
        super.publish();
    }
}
