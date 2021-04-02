import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC5 {
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			// 1. Driver Loading
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2. Connection
			con = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/scott?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8",
					"ssafy", "ssafy");
			// 3. Statement Create
			int empno = 8888;
			String name = "도우너";
			int sal = 3000;
			int deptno = 30;
			String sql = "insert into emp(empno, ename, sal, deptno) values(?,?,?,?)";
//					"select * from emp where sal > ? and deptno = ? ";
			
			//동적 바인딩
			PreparedStatement pSt = con.prepareStatement(sql);
			
			//?의 개수와 set 개수가 같아야 함
			pSt.setInt(1, empno); //첫번째 ?표의 값이 첫번째에 binding 됨
			pSt.setString(2, name);
			pSt.setInt(3, sal);
			pSt.setInt(4, deptno);
			
			// 4. SQL Excute
			//삽입
			pSt.executeUpdate();
//			조회
//			rs = pSt.executeQuery();
			System.out.println("입력성공");
//			while (rs.next()) {
//				System.out.println(rs.getString("ename") + " , " + rs.getInt("sal"));
//			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				// 5. close
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}
}