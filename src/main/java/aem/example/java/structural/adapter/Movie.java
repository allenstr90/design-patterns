package aem.example.java.structural.adapter;

public class Movie implements Synopsis {

    private String synopsis;

    public Movie(String synopsis) {
        this.synopsis = synopsis;
    }

    @Override
    public String getContent() {
        return synopsis;
    }
}
