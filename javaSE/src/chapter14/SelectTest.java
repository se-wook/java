package chapter14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectTest {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			/**
				//1. driver 로딩 (한번만)
				Class.forName("com.mysql.cj.jdbc.Driver");
				//2. db연결
				String url = "jdbc:mysql://localhost:3306/ssafydb?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8";
				String user = "ssafy";
				String password = "ssafy";
				con = DriverManager.getConnection(url, user, password);
			*/
			con = DBUtil.getConnection();
			//3. SQL문을 위한 Statement 생성
			stmt = con.prepareStatement("select * from emp");
			rs = stmt.executeQuery(); // select문 수행 시킴
			System.out.println("empno\tename\tsal\tdeptno\tjob");
			//4. 결과 처리
			//  next()	:	다음 데이터가 있으면 true, 없으면 false
			//		   		커서를 다음행으로 이동
			while(rs.next()) {
				// 데이터 추출  getXXX(int columnNo) getXXX(String columnName)
				System.out.printf("%d\t%s\t%d\t%d\t%s\n",
								rs.getInt("empno"),rs.getString("ename"),
								rs.getInt("sal"),rs.getInt("deptno"),rs.getString("job"));
				
			}
		} catch (Exception e) {
			System.out.println("드라이버 로딩 실패");
		} finally {
			/**
				//5. db 연결 종료
				// 열었던 순서로 닫는다.
				if(rs != null) try { rs.close(); } catch (Exception e) {}
				if(stmt != null) try { stmt.close(); } catch (Exception e) {}
				if(con != null) try { con.close(); } catch (Exception e) {}
			*/
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(con);
		} 
	}

}
