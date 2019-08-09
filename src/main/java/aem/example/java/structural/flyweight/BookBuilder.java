package aem.example.java.structural.flyweight;

public class BookBuilder implements Builder {
    private FormatType type;

    public BookBuilder(FormatType type) {
        this.type = type;
    }

    @Override
    public Resource build(String content) {
        return new Book(type, content);
    }
}
