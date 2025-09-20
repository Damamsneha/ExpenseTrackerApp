package main;
import dao.UserDAO;
import model.User;
import service.ExpenseService;
import java.util.Scanner;
public class ExpenseTrackerApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        UserDAO userDAO = new UserDAO();
        ExpenseService service = new ExpenseService();

        System.out.println("===== Expense Tracker =====");
        User current = null;
        while (current == null) {
            System.out.println("1) Register  2) Login");
            int ch = sc.nextInt(); sc.nextLine();
            if (ch == 1) {
                System.out.print("Username: ");
                String u = sc.nextLine();
                System.out.print("Password: ");
                String p = sc.nextLine();
                if (userDAO.registerUser(new User(0, u, p))) {
                    System.out.println("Registered. Please login.");
                }
            } else if (ch == 2) {
                System.out.print("Username: ");
                String u = sc.nextLine();
                System.out.print("Password: ");
                String p = sc.nextLine();
                current = userDAO.login(u, p);
                if (current == null) System.out.println("Invalid credentials.");
            }
        }

        while (true) {
            System.out.println("\n1) Add  2) View  3) Update  4) Delete  5) Exit");
            int c = sc.nextInt(); sc.nextLine();
            switch (c) {
                case 1 -> service.addExpense(current.getUserId(), sc);
                case 2 -> service.viewExpenses(current.getUserId());
                case 3 -> service.updateExpense(sc);
                case 4 -> service.deleteExpense(sc);
                case 5 -> System.exit(0);
                default -> System.out.println("Invalid choice.");
            }
        }
    }


}
