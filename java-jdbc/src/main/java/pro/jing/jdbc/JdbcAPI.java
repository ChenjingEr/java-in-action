package pro.jing.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author JING
 * @date 2018年9月5日
 * @describe JDBC 开发基本流程
 */
public class JdbcAPI {

	public static void main(String[] args) {
		Statement stmt = null;
		try {
			// 1.加载驱动
			// 2.驱动管理器获取连接
			// 3.创建执行对象
			// 4.执行sql
			// 5.获取结果集
			Connection con = ConnectionUtil.getConnection();
			stmt = con.createStatement();
			String sql = "select id, name from jdbc_test";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getInt("id") + " -> " + rs.getString("name"));
			}
			
			
			

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				ConnectionUtil.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
