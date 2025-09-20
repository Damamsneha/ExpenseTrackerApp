package grp3;

public class Book {
    private int id;
    private String title;
    private Author author;
    private boolean isBorrowed;

    public Book(int id, String title, Author author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public Author getAuthor() { return author; }
    public boolean isBorrowed() { return isBorrowed; }

    public void setTitle(String title) { this.title = title; }
    public void setAuthor(Author author) { this.author = author; }
    public void setBorrowed(boolean borrowed) { isBorrowed = borrowed; }

    @Override
    public String toString() {
        return "ID: " + id + " | Title: " + title + " | Author: " + author.getName() + " | Borrowed: " + (isBorrowed ? "Yes" : "No");
    }
}
