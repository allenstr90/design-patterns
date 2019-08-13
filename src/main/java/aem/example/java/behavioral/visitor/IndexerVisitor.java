package aem.example.java.behavioral.visitor;

import java.util.ArrayList;
import java.util.List;

public class IndexerVisitor implements Visitor {

    private List<String> list;

    public IndexerVisitor() {
        this.list = new ArrayList<>();
    }

    @Override

    public void visit(Book book) {
        System.out.println("IndexerVisitor:visit book " + book.getTitle());
        list.add(book.getTitle());
    }

    @Override
    public void visit(Movie movie) {
        System.out.println("IndexerVisitor:visit movie " + movie.getName());
        list.add(movie.getName());
    }

    public String getIndexedElements() {
        return String.join(", ", list);
    }
}
