package aem.example.java.structural.bridge;

public class MovieReader implements ResourceReader {
    private Movie movie;

    public MovieReader(Movie movie) {
        this.movie = movie;
    }

    @Override
    public Object readContent() {
        System.out.println("Reading content from movie...");
        return movie.getContent();
    }

    @Override
    public boolean store() {
        System.out.println("Trying store movie...");
        return movie.getContent().length > 0;
    }
}
