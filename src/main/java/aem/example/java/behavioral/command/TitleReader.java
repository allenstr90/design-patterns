package aem.example.java.behavioral.command;

public class TitleReader implements Operation {
    private Book book;

    public TitleReader(Book book) {
        this.book = book;
    }


    @Override
    public void execute() {
        System.out.println("TitleReader:execute");
        book.readTitle();
    }
}
