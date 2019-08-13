package aem.example.java.behavioral.visitor;

public class Movie implements Visitable {
    private String name;

    public Movie(String name) {
        this.name = name;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String getName() {
        return name;
    }
}
