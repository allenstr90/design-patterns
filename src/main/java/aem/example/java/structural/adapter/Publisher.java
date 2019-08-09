package aem.example.java.structural.adapter;

public class Publisher {

    private Publisher() {
    }

    public static String publish(Synopsis provider) {
        System.out.println("Publish content");
        return provider.getContent();
    }
}
