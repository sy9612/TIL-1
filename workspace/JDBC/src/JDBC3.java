import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC3 {
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
			st = con.createStatement();
			// 4. SQL Excute
			rs = st.executeQuery("select * from emp");

			while (rs.next()) {
				System.out.println(rs.getString("ename") + " , " + rs.getInt("sal"));
			}
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