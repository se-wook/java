package chapter14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class InsertTest {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement stmt = null;

		try {
			/** connection은 기본적으로 auto commit이다.*/
			con = DBUtil.getConnection();
			// sql문 마지막에 세미콜론 넣으면 안됨.
			String sql = "insert into emp(empno, ename, sal) values(?,?,?)";
			stmt = con.prepareStatement(sql);
			// 데이터 설정 : setXXX(parameterIndex, value);
			stmt.setInt(1,3333);			// 첫번째 물음표(?)에 int 타입으로 3333을 설정.
			stmt.setString(2, "ssafy");
			stmt.setInt(3, 4500);
			int row = stmt.executeUpdate(); // insert, update, delete 문 실행시 사용.
			System.out.printf("%d행이 수행됐습니다.",row);
		} catch (Exception e) {
			System.out.println("드라이버 로딩 실패");
		} finally {
			DBUtil.close(stmt);
			DBUtil.close(con);
		} 
	}
}
