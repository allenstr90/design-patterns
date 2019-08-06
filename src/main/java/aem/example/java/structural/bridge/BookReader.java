package aem.example.java.structural.bridge;

public class BookReader implements ResourceReader {
    private Book book;

    public BookReader(Book book) {
        this.book = book;
    }

    @Override
    public Object readContent() {
        System.out.println("Reading content from book...");
        return book.getResume();
    }

    @Override
    public boolean store() {
        System.out.println("Trying store book...");
        return (!book.getResume().isEmpty() && !book.getResume().isBlank());
    }
}
