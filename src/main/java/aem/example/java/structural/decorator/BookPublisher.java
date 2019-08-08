package aem.example.java.structural.decorator;

public class BookPublisher implements Publisher {
    private Book book;

    public BookPublisher(Book book) {
        this.book = book;
    }

    @Override
    public String publish() {
        System.out.println("Publish book with content " + book.getTitle());
        return book.getTitle();
    }
}
