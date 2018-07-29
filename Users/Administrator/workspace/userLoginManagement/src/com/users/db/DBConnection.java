package com.users.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnection {
	private static String user="root";
	private static String password="tangjie";
	private static String url="jdbc:mysql://127.0.0.1:3306/login";
	private static String driver="com.mysql.jdbc.Driver";
	private static Connection conn=null;
	
	static 
	{
		try{
			Class.forName(driver);//¼ÓÔØÇý¶¯³ÌÐò
			conn=DriverManager.getConnection(url, user, password);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	//
	public void exec(String sql){
		try{
			Statement cmd= conn.createStatement();
			cmd.executeQuery(sql);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	//
	public ResultSet query(String sql)
	{
		ResultSet rs=null;
		try{
			
		}
	}
	
}
