package aem.example.java.creational.builder;

public class Book {

    private final String title;
    private Long id;
    private String isbn;
    private String edition;
    private Double price;

    private Book(BookBuilder BookBuilder) {
        this.id = BookBuilder.id;
        this.title = BookBuilder.title;
        this.isbn = BookBuilder.isbn;
        this.edition = BookBuilder.edition;
        this.price = BookBuilder.price;
    }

    public static BookBuilder builder() {
        return new BookBuilder();
    }

    //<editor-fold desc="Getters">
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getEdition() {
        return edition;
    }

    public Double getPrice() {
        return price;
    }
    //</editor-folds>


    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", id=" + id +
                ", isbn='" + isbn + '\'' +
                ", edition='" + edition + '\'' +
                ", price=" + price +
                '}';
    }

    public static class BookBuilder {
        private Long id;
        private String title;
        private String isbn;
        private String edition;
        private Double price;

        public BookBuilder() {
        }

        //<editor-fold desc="Setters">
        public BookBuilder setIsbn(String isbn) {
            this.isbn = isbn;
            return this;
        }

        public BookBuilder setEdition(String edition) {
            this.edition = edition;
            return this;
        }

        public BookBuilder setPrice(Double price) {
            this.price = price;
            return this;
        }

        public BookBuilder setTitle(String title) {
            this.title = title;
            return this;
        }
        //</editor-fold>

        public Book build() {
            return new Book(this);
        }

    }


}
