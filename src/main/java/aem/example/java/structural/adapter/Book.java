package aem.example.java.structural.adapter;

public class Book implements Resume {
    private String resume;

    public Book(String resume) {
        this.resume = resume;
    }

    @Override
    public String getContent() {
        return resume;
    }
}
