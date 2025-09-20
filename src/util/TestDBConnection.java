package util;
import java.sql.Connection;
public class TestDBConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
            Connection conn = DBConnection.getConnection();
            if (conn != null) {
                System.out.println("✅ Connection successful!");
                conn.close();
            }
        } catch (Exception e) {
            System.out.println("❌ Connection failed: " + e.getMessage());
        }
	}

}
