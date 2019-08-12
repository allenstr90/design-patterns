package aem.example.java.behavioral.command;

public class ContentReader implements Operation {
    private Book book;

    public ContentReader(Book book) {
        this.book = book;
    }

    @Override
    public void execute() {
        System.out.println("ContentReader:execute");
        book.readContent();
    }
}
