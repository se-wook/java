package chapter14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TransactionTest {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement stmt1 = null;
		PreparedStatement stmt2= null;
		PreparedStatement stmt3 = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnection();
			con.setAutoCommit(false); // auto commit 막음
			String sql1 = " select max(no)+1 as no from board ";
			String sql2 = " insert into board(no, id, title, contents) values(?,?,?,?) ";
			String sql3 = " insert into boardfile(rfilename, sfilename, bno) values(?,?,?) ";
			
			stmt1 = con.prepareStatement(sql1);
			rs = stmt1.executeQuery();
			int no =0;
			if(rs.next()) {
				no = rs.getInt("no");
			}
			System.out.println(no);
			stmt2 = con.prepareStatement(sql2);
			stmt2.setInt(1, no);
			stmt2.setString(2, "ssafy");
			stmt2.setString(3, "네번째 jdbc");
			stmt2.setString(4, "잘 되나용?");
			stmt2.executeUpdate();
			
//			if(true) throw new RuntimeException("트랜잭션 예제를 위한 오류");
			
			stmt3 = con.prepareStatement(sql3);
			stmt3.setString(1, "a.txt");
			stmt3.setString(2, "a.txt");
			stmt3.setInt(3, no);
			stmt3.executeUpdate();
			
			con.commit(); // error가 나지 않은 상황이므로 DB에 반영하기 위해 commit
			
		} catch (Exception e) {
			// error가 난 상황이라면 수행한 모든 DML은 ROLLBACK 해야 한다.
			if(con != null) try {con.rollback();} catch (Exception e1) {}
			e.printStackTrace();
			System.out.println("드라이버 로딩 실패");
		} finally {

			DBUtil.close(rs);
			DBUtil.close(stmt1);
			DBUtil.close(stmt2);
			DBUtil.close(stmt3);
			DBUtil.close(con);
		} 
	}

}
