import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC4 {
   public static void main(String[] args) {

      Connection con = null;
      Statement st = null;
      ResultSet rs = null;
      try {
         // 1. Driver Load
         Class.forName("com.mysql.cj.jdbc.Driver");

         // 2. Connection
         con = DriverManager.getConnection(
               "jdbc:mysql://127.0.0.1:3306/scott?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8", "ssafy",
               "ssafy");

         // 3. Statement Create
         int sal = 1000;
         int deptno = 30;
         String sql = "select * from emp where sal > ? and deptno = ?";
         PreparedStatement pSt = con.prepareStatement(sql);
         pSt.setInt(1, sal);
         pSt.setInt(2, deptno);
         // 4. SQL Execute
         rs = pSt.executeQuery();
         while (rs.next()) {
            System.out.println(rs.getString("ename")+","+rs.getInt("sal"));
         }
         
         
      } catch (Exception e) {
         e.printStackTrace();
         System.out.println("class loading failed");
      } finally {
         // 5. close - ERROR가 발생하든 아니든 반드시 실행되어야 한다.
         try {
            try {if (rs!=null) {rs.close();}}catch (Exception e) {}
            try {if (rs!=null) {st.close();}}catch (Exception e) {}
            try {if (rs!=null) {con.close();}}catch (Exception e) {}
         } catch (Exception e) {
            e.printStackTrace();
         }
      }



      
   }
}