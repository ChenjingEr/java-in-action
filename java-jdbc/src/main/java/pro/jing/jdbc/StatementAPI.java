package pro.jing.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author JING
 * @date 2018年9月5日
 * @describe Statement用来执行静态sql
 */
public class StatementAPI {

	public static void main(String[] args) {

		Statement stmt = null;

		try {
			Connection con = ConnectionUtil.getConnection();
			stmt = con.createStatement();

			
			System.out.println("**********************execute************************");
			// execute
			String sql = "select id, name from jdbc_test";
			if (stmt.execute(sql)) {
				ResultSet r1 = stmt.getResultSet();
				while (r1.next())
					System.out.println(r1.getInt("id") + " -> " + r1.getString("name"));
			}
			
			System.out.println("**********************executeQuery************************");
			
			//executeQuery
			ResultSet r2 =stmt.executeQuery(sql);
			while(r2.next()) {
				System.out.println(r2.getInt("id") + " -> " + r2.getString("name"));
			}
			
			System.out.println("**********************executeUpdate************************");

			//executeUpdate
			String sql01 = "insert into jdbc_test(name) values('qiqi03')";
			int row = stmt.executeUpdate(sql01);
			System.out.println(row);
			

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
