package grp3;
import java.util.ArrayList;
import java.util.List;

public class Author {
    private int id;
    private String name;
    private List<Book> booksWritten = new ArrayList<>();

    public Author(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public List<Book> getBooksWritten() { return booksWritten; }

    public void addBook(Book book) {
        booksWritten.add(book);
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Books Written: " + booksWritten.size();
    }
}
