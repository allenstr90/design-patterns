package aem.example.java.behavioral.command;

public class Book {
    private String title;
    private String content;

    public Book(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void readTitle() {
        System.out.println("Reading title book " + this.title);
    }

    public void readContent() {
        System.out.println("Read content " + this.content);
    }
}
