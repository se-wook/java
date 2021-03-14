package chapter14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil { // 객체 생성없이 접근할 수 있도록 static

	/**
	 * 재사용 : 로딩, 연결, 해제  
	 */
	static String url = "jdbc:mysql://localhost:3306/ssafydb?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8";
	static String user = "ssafy";
	static String password = "ssafy";
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		} catch (Exception e) {
			System.out.println("driver 로딩 실패");
		}
	}
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}
	public static void close(Connection con) {
		if(con != null) {
			try {con.close();} catch (Exception e) {}
		}
	}
	public static void close(PreparedStatement stmt) {
		if(stmt != null) {
			try {stmt.close();} catch (Exception e) {}
		}
	}
	public static void close(ResultSet rs) {
		if(rs != null) {
			try {rs.close();} catch (Exception e) {}
		}
	}
}
