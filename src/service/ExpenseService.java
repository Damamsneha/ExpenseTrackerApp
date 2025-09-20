package service;
import dao.ExpenseDAO;
import model.Expense;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
public class ExpenseService {
	private final ExpenseDAO expenseDAO = new ExpenseDAO();

    public void addExpense(int userId, Scanner sc) {
        System.out.print("Category: ");
        String category = sc.next();
        System.out.print("Amount: ");
        while (!sc.hasNextDouble()) { System.out.print("Enter a valid amount: "); sc.next(); }
        double amount = sc.nextDouble();
        sc.nextLine();
        System.out.print("Note: ");
        String note = sc.nextLine();
        Expense ex = new Expense(0, userId, category, amount, note, new Date());
        expenseDAO.addExpense(ex);
    }

    public void viewExpenses(int userId) {
        List<Expense> list = expenseDAO.getExpensesByUser(userId);
        if (list.isEmpty()) {
            System.out.println("No expenses found.");
            return;
        }
        System.out.println("ID | Category | Amount | Note | Date");
        for (Expense e : list) {
            System.out.println(e.getExpenseId() + " | " + e.getCategory() + " | " + e.getAmount() + " | " + e.getNote() + " | " + e.getDate());
        }
    }

    public void deleteExpense(Scanner sc) {
        System.out.print("Expense ID to delete: ");
        int id = sc.nextInt();
        expenseDAO.deleteExpense(id);
    }

    public void updateExpense(Scanner sc) {
        System.out.print("Expense ID to update: ");
        int id = sc.nextInt();
        System.out.print("New Category: ");
        String category = sc.next();
        System.out.print("New Amount: ");
        while (!sc.hasNextDouble()) { System.out.print("Enter a valid amount: "); sc.next(); }
        double amount = sc.nextDouble();
        sc.nextLine();
        System.out.print("New Note: ");
        String note = sc.nextLine();
        expenseDAO.updateExpense(id, category, amount, note, new Date());
    }
}
