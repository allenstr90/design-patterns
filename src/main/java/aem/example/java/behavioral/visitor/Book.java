package aem.example.java.behavioral.visitor;

public class Book implements Visitable {
    private String title;

    public Book(String title) {
        this.title = title;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String getTitle() {
        return title;
    }
}
