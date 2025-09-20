package util;
import java.sql.Connection;            // ensures Connection resolves [web:43]
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	 private static final String URL =
		        "jdbc:mysql://localhost:3306/expense_tracker?useSSL=false&serverTimezone=UTC"; // [web:33]

		    // Use the same username shown in Workbench (root), and your real password [web:33]
		    private static final String USER = "root";           // [web:33]
		    private static final String PASSWORD = "0000";       // [web:33]

		    public static Connection getConnection() throws SQLException {
		        return DriverManager.getConnection(URL, USER, PASSWORD); 
	
	}

}