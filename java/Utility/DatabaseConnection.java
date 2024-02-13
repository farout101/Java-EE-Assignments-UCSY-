package Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	// Database connection parameters
	private static final String URL = "jdbc:mysql://localhost/ucsy";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";

	// Method to establish a database connection
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}
}
