package dao;
import model.Expense;
import util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExpenseDAO {
	public void addExpense(Expense e) {
        String sql = "INSERT INTO user_expenses (user_id, expense_category, expense_amount, expense_note, expense_date) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, e.getUserId());
            ps.setString(2, e.getCategory());
            ps.setDouble(3, e.getAmount());
            ps.setString(4, e.getNote());
            ps.setDate(5, new java.sql.Date(e.getDate().getTime()));
            ps.executeUpdate();
            System.out.println("Expense added.");
        } catch (Exception ex) { ex.printStackTrace(); }
    }

    public List<Expense> getExpensesByUser(int userId) {
        List<Expense> list = new ArrayList<>();
        String sql = "SELECT expense_id, user_id, expense_category, expense_amount, expense_note, expense_date " +
                     "FROM user_expenses WHERE user_id=? ORDER BY expense_date DESC, expense_id DESC";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, userId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(new Expense(
                        rs.getInt("expense_id"),
                        rs.getInt("user_id"),
                        rs.getString("expense_category"),
                        rs.getDouble("expense_amount"),
                        rs.getString("expense_note"),
                        rs.getDate("expense_date")
                    ));
                }
            }
        } catch (Exception ex) { ex.printStackTrace(); }
        return list;
    }

    public void deleteExpense(int expenseId) {
        String sql = "DELETE FROM user_expenses WHERE expense_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, expenseId);
            ps.executeUpdate();
            System.out.println("Expense deleted.");
        } catch (Exception ex) { ex.printStackTrace(); }
    }

    public void updateExpense(int expenseId, String category, double amount, String note, java.util.Date date) {
        String sql = "UPDATE user_expenses SET expense_category=?, expense_amount=?, expense_note=?, expense_date=? WHERE expense_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, category);
            ps.setDouble(2, amount);
            ps.setString(3, note);
            ps.setDate(4, new java.sql.Date(date.getTime()));
            ps.setInt(5, expenseId);
            ps.executeUpdate();
            System.out.println("Expense updated.");
        } catch (Exception ex) { ex.printStackTrace(); }
    }
}
