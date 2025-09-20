package grp3;
import java.util.*;

public class LibraryManager {
    private Map<Integer, Book> books = new HashMap<>();
    private Map<Integer, Author> authors = new HashMap<>();
    private Map<Integer, Borrower> borrowers = new HashMap<>();

    public void addAuthor(int id, String name) {
        authors.put(id, new Author(id, name));
        System.out.println("Author added successfully.");
    }

    public void listAuthors() {
        if (authors.isEmpty()) {
            System.out.println("No authors found.");
        } else {
            authors.values().forEach(System.out::println);
        }
    }

    public void addBook(int id, String title, int authorId) {
        Author author = authors.get(authorId);
        if (author == null) {
            System.out.println("Author not found. Please add the author first.");
            return;
        }
        Book book = new Book(id, title, author);
        books.put(id, book);
        author.addBook(book);
        System.out.println("Book added successfully.");
    }

    public void updateBook(int id, String newTitle, int newAuthorId) {
        Book book = books.get(id);
        if (book == null) {
            System.out.println("Book not found.");
            return;
        }
        Author newAuthor = authors.get(newAuthorId);
        if (newAuthor == null) {
            System.out.println("New author not found.");
            return;
        }
        book.setTitle(newTitle);
        book.setAuthor(newAuthor);
        System.out.println("Book updated successfully.");
    }

    public void deleteBook(int id) {
        Book removed = books.remove(id);
        if (removed != null) {
            System.out.println("Book deleted successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("No books found.");
        } else {
            books.values().forEach(System.out::println);
        }
    }

    public void addBorrower(int id, String name) {
        borrowers.put(id, new Borrower(id, name));
        System.out.println("Borrower added successfully.");
    }

    public void listBorrowers() {
        if (borrowers.isEmpty()) {
            System.out.println("No borrowers found.");
        } else {
            borrowers.values().forEach(System.out::println);
        }
    }

    public void checkOutBook(int bookId, int borrowerId) {
        Book book = books.get(bookId);
        Borrower borrower = borrowers.get(borrowerId);

        if (book == null || borrower == null) {
            System.out.println("Book or Borrower not found.");
            return;
        }

        if (book.isBorrowed()) {
            System.out.println("Book is already borrowed.");
        } else {
            book.setBorrowed(true);
            borrower.borrowBook(book);
            System.out.println("Book borrowed successfully.");
        }
    }

    public void checkInBook(int bookId, int borrowerId) {
        Book book = books.get(bookId);
        Borrower borrower = borrowers.get(borrowerId);

        if (book == null || borrower == null) {
            System.out.println("Book or Borrower not found.");
            return;
        }

        if (!book.isBorrowed()) {
            System.out.println("Book is not currently borrowed.");
        } else {
            book.setBorrowed(false);
            borrower.returnBook(book);
            System.out.println("Book returned successfully.");
        }
    }
}
