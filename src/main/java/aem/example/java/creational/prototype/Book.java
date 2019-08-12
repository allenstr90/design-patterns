package aem.example.java.creational.prototype;

public class Book implements PrototypeCapable {
    private String title;

    public String getTitle() {
        return title;
    }

    public Book setTitle(String title) {
        this.title = title;
        return this;
    }

    @Override
    public String toString() {
        return Book.class.getSimpleName();
    }

    @Override
    public PrototypeCapable clone() throws CloneNotSupportedException {
        System.out.println("Cloning book...");
        return (Book) super.clone();
    }

}
