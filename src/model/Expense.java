package model;
import java.util.Date;
public class Expense {
	 private int expenseId;      // maps to user_expenses.expense_id
	    private int userId;         // maps to user_expenses.user_id
	    private String category;    // maps to user_expenses.expense_category
	    private double amount;      // maps to user_expenses.expense_amount
	    private String note;        // maps to user_expenses.expense_note
	    private Date date;          // maps to user_expenses.expense_date

	    public Expense() {}
	    public Expense(int expenseId, int userId, String category, double amount, String note, Date date) {
	        this.expenseId = expenseId;
	        this.userId = userId;
	        this.category = category;
	        this.amount = amount;
	        this.note = note;
	        this.date = date;
	    }
	    public int getExpenseId() { return expenseId; }
	    public int getUserId() { return userId; }
	    public String getCategory() { return category; }
	    public double getAmount() { return amount; }
	    public String getNote() { return note; }
	    public Date getDate() { return date; }
}
