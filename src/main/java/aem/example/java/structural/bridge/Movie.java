package aem.example.java.structural.bridge;

public class Movie {
    private byte[] content;

    public Movie(byte[] content) {
        this.content = content;
    }

    public byte[] getContent() {
        return content;
    }
}
