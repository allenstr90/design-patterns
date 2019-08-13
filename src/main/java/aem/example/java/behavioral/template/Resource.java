package aem.example.java.behavioral.template;

public abstract class Resource {
    protected String title;
    protected String content;

    public Resource(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public final void build() {
        addTitle();
        addContent();
        addExtraData();
    }

    protected void addContent() {
        this.content = this.content.toLowerCase();
    }

    protected void addTitle() {
        this.title.repeat(2);
    }

    public abstract void addExtraData();
}
