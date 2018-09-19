package pro.jing.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	private static final String URL = "jdbc:mysql://localhost:3306/demo?serverTimezone=UTC";
	private static final String NAME = "root";
	private static final String PASS = "root";

	private static Connection con = null;

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(URL, NAME, PASS);
		return con;
	}

	public static void closeConnection() throws SQLException {
		if (con != null)
			con.close();
	}

}
