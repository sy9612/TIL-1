import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC1 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 1. Driver Loading
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// 2. Connection
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/scott?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8","ssafy","ssafy");
		// 3. Statement Create
		Statement st = con.createStatement();
		// 4. SQL Excute
		ResultSet rs = st.executeQuery("select * from emp");
		
		while(rs.next()) {//다음꺼 가져옴
			System.out.println(rs.getString("ename")+" , " + rs.getInt("sal"));
		}
		// 5. close  
		con.close();
		st.close();
		rs.close();
		
	}

}