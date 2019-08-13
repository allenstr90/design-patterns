package aem.example.java.behavioral.template;

public class Book extends Resource {

    private int cantPages;

    public Book(String title, String content, int cantPages) {
        super(title, content);
        this.cantPages = cantPages;
    }

    @Override
    public void addExtraData() {
        super.title = super.title.toUpperCase();
        super.content = super.content + " -> " + cantPages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "cantPages=" + cantPages +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
