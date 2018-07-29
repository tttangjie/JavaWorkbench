package Test;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
public class SQLTest {
	public static void main(String[] args) {
        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        String dbClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/wty_1";
        String sql = "select * from admin";
        /*try {
        	Class.forName(dbClassName);
        	System.out.println("成功");
        }catch(ClassNotFoundException e){
        	System.out.println("失败");
        	e.printStackTrace();
        }*/
        try{
        	 // 连接数据库
            conn = DriverManager.getConnection(url, "root", "7988783");
            System.out.println("成功");
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String password  =rs.getString("password");
                System.out.println("id:" + id + "\tname:" + name + "password:" + password);
            }
            if (rs != null) {
                rs.close();
                rs = null;
            }
            if (stmt != null) {
                stmt.close();
                stmt = null;
            }
            if (conn != null) {
                conn.close();
                conn = null;
            }
        }catch(Exception e){
        	System.out.println("失败");
        	e.printStackTrace();
        }
}
}
