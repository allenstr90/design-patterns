package aem.example.java.behavioral.template;

public class Movie extends Resource {
    private String location;

    public Movie(String title, String content, String location) {
        super(title, content);
        this.location = location;
    }

    @Override
    public void addExtraData() {
        this.content = this.content.stripLeading() + " -> " + location;
    }

    @Override
    protected void addTitle() {
        super.title = super.title + " | Movie:addTitle";
    }

    @Override
    public String toString() {
        return "Movie{" +
                "location='" + location + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
