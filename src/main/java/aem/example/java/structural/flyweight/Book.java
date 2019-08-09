package aem.example.java.structural.flyweight;

public class Book extends Resource {


    public Book(FormatType type, String content) {
        super(type, content);
    }

    private String getTitle() {
        return super.content;
    }
}
