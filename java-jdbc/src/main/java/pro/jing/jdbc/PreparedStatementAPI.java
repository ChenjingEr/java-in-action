package pro.jing.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author JING
 * @date 2018年9月5日
 * @describe 预编译执行
 */

public class PreparedStatementAPI {

	public static void main(String[] args) {
		
		PreparedStatement ps = null;
		
		try {
			Connection con = ConnectionUtil.getConnection();
			//预编译
			String sql = "select id, name from jdbc_test where name = 'qiqi03'";
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
				System.out.println(rs.getInt("id") + " -> " + rs.getString("name"));
				
			System.out.println("**************dynamicSql*******************");
			//动态参数
			String sql01 = "select id, name from jdbc_test where name = ?";
			PreparedStatement ps01 =  con.prepareStatement(sql01);
			ps01.setString(1, "qiqi01");
			ResultSet rs01 = ps01.executeQuery();
			while(rs01.next())
				System.out.println(rs01.getInt("id") + " -> " + rs01.getString("name"));
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
