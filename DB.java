package Student_class;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
	static Connection conn = null;

	public static Connection connect() {
		try {
			String url = "jdbc:mysql://localhost:3306/Student_mgmt";
			String db = "Ashvini";
			String userName = "root";
			String password = "root";
	        conn = DriverManager.getConnection(url, userName, password);  
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
