package grp3;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibraryManager libraryManager = new LibraryManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n====== Library Management System ======");
            System.out.println("1. Add Book");
            System.out.println("2. Update Book");
            System.out.println("3. Delete Book");
            System.out.println("4. List Books");
            System.out.println("5. Add Author");
            System.out.println("6. List Authors");
            System.out.println("7. Add Borrower");
            System.out.println("8. List Borrowers");
            System.out.println("9. Borrow Book");
            System.out.println("10. Return Book");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int bookId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Book Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author ID: ");
                    int authorId = scanner.nextInt();
                    scanner.nextLine();
                    libraryManager.addBook(bookId, title, authorId);
                    break;
                case 2:
                    System.out.print("Enter Book ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new Title: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Enter new Author ID: ");
                    int newAuthorId = scanner.nextInt();
                    scanner.nextLine();
                    libraryManager.updateBook(updateId, newTitle, newAuthorId);
                    break;
                case 3:
                    System.out.print("Enter Book ID to delete: ");
                    int delId = scanner.nextInt();
                    scanner.nextLine();
                    libraryManager.deleteBook(delId);
                    break;
                case 4:
                    libraryManager.listBooks();
                    break;
                case 5:
                    System.out.print("Enter Author ID: ");
                    int authId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Author Name: ");
                    String authName = scanner.nextLine();
                    libraryManager.addAuthor(authId, authName);
                    break;
                case 6:
                    libraryManager.listAuthors();
                    break;
                case 7:
                    System.out.print("Enter Borrower ID: ");
                    int borrowerId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Borrower Name: ");
                    String borrowerName = scanner.nextLine();
                    libraryManager.addBorrower(borrowerId, borrowerName);
                    break;
                case 8:
                    libraryManager.listBorrowers();
                    break;
                case 9:
                    System.out.print("Enter Book ID to borrow: ");
                    int bId = scanner.nextInt();
                    System.out.print("Enter Borrower ID: ");
                    int borId = scanner.nextInt();
                    scanner.nextLine();
                    libraryManager.checkOutBook(bId, borId);
                    break;
                case 10:
                    System.out.print("Enter Book ID to return: ");
                    int retId = scanner.nextInt();
                    System.out.print("Enter Borrower ID: ");
                    int retBorId = scanner.nextInt();
                    scanner.nextLine();
                    libraryManager.checkInBook(retId, retBorId);
                    break;
                case 0:
                    System.out.println("Exiting system. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
