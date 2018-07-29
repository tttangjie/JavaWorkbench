package com.yonghu.DButil;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class DButil
{
	private static String url;
	private static String username;
	private static String password;
	private static String driver;
	static
	{
		InputStream is=DButil.class.getClassLoader().getResourceAsStream("config/jdbc.properties");
		Properties porp=new Properties();
		try
		{
			porp.load(is);
			url=porp.getProperty("url");
			username=porp.getProperty("username");
			password=porp.getProperty("password");
			driver=porp.getProperty("driver");
			Class.forName(driver);
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}//加载配置文件
	public static Connection getConnection()//数据库连接
	{
		try
		{
			Connection con=DriverManager.getConnection(url,username,password);
			return con;
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	public static void CloseResource(Connection con,PreparedStatement ps, ResultSet rs)//断开连接
	{
		if(rs!=null)
			try
			{
				rs.close();
			} catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				if(ps != null){
					try {
						ps.close();
					} catch (SQLException e) {
						throw new RuntimeException(e);
					}finally{
						if(con != null){
							try {
								con.close();
							} catch (SQLException e) {
								throw new RuntimeException(e);
							}
						}
					}
				}
			}
		}
}
	

