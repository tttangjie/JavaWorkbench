package test;

import java.sql.*;

public class test0 {

	public static void main(String[] args)
	{
		String user="root";
		String password="tangjie";
		String url="jdbc:mysql://127.0.0.1:3306/login";
		String driver="com.mysql.jdbc.Driver";
		Connection conn=null;
		try{
			Class.forName(driver);//加载驱动程序
			conn=DriverManager.getConnection(url, user, password);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		String sql="select * from user";
		Statement cmd;
		try {
			cmd = conn.createStatement();
			ResultSet rs=cmd.executeQuery(sql);
			while(rs.next())
		    {
		    	System.out.println("用户名："+rs.getString("id")+" 姓名："+rs.getString("name"));
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
