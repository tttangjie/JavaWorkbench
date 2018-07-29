package com.yonghu.DBdemolinter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yonghu.DBdemol.DBdemol;
import com.yonghu.DButil.DButil;
import com.yonghu.user.User;

public class DBdemolinter implements DBdemol
{
    private Connection con=null;
    public DBdemolinter()
    {
    	con=DButil.getConnection();
    }
	public void add(User user)
	{
		// TODO Auto-generated method stub
		PreparedStatement ps=null;
		try {
			String sql = "INSERT INTO user(username,password,age,sex,info,power) VALUES(?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassword());
			ps.setInt(3, user.getAge());
			ps.setString(4, user.getSex());
			ps.setString(5, user.getInfo());
			ps.setInt(6, user.getPower());
			
			int count = ps.executeUpdate();
			if(count > 0){
				System.out.println("添加成功");
			}else{
				System.out.println("添加失败");
			}
			
		}
		catch (SQLException e) 
		{
			throw new RuntimeException(e);
		}
		finally
		{
			DButil.CloseResource(con,ps,null);
		}
	}

	public void delete(int id)
	{
		// TODO Auto-generated method stub
        PreparedStatement ps=null;
        try
        {
        	String sql="DELETE FROM user WHERE id=?";
        	ps=con.prepareStatement(sql);
        	int count=ps.executeUpdate();
        	if(count>0)
        	{
        		System.out.println("删除成功");
        	}
        	else
        	{
        		System.out.println("删除失败");
        	}
        }
        catch (SQLException e) 
        {
			throw new RuntimeException(e);
		}
        finally
        {
			DButil.CloseResource(con,ps,null);
		}
	}

	public void update(User user)
	{
		// TODO Auto-generated method stub
		PreparedStatement ps=null;
		try {
			String sql = "UPDATE  user SET username=?,age=?,sex=?,info=?,power=? WHERE id=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setInt(2, user.getAge());
			ps.setString(3, user.getSex());
			ps.setString(4, user.getInfo());
			ps.setInt(5, user.getPower());
			
			int count = ps.executeUpdate();
			if(count > 0)
			{
				System.out.println("修改成功");
			}
			else
			{
				System.out.println("修改失败");
			}
			
		}
		catch (SQLException e) 
		{
			throw new RuntimeException(e);
		}
		finally
		{
			DButil.CloseResource(con,ps,null);
		}
	}

	public User findbyname(String username)
	{
		// TODO Auto-generated method stub
       PreparedStatement ps=null;
       ResultSet rs=null;
       try
       {
    	   String sql="SELECT * FROM user WHERE id=?";
    	   ps=con.prepareStatement(sql);
    	   rs=ps.executeQuery();
    	   User user=new User();
    	   while(rs.next())
    	   {
    		   user.setUserName(rs.getString(1));
    		   user.setPassword(rs.getString(2));
    		   user.setAge(rs.getInt(3));
    		   user.setSex(rs.getString(4));
    		   user.setInfo(rs.getString(5));
    		   user.setPower(rs.getInt(6));
    	   }
    	   return user;
       }
       catch (SQLException e) 
	   {
			throw new RuntimeException(e);
	   }
	   finally
	   {
			DButil.CloseResource(con,ps,rs);
	   }
	}

	@Override
	public List<User> findbyall()
	{
		// TODO Auto-generated method stub
		PreparedStatement ps=null;
		ResultSet rs=null;
		try
		{
			String sql="SELECT * FROM user";
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			List<User> list=new ArrayList<User>();
			while(rs.next())
			{
				User user=new User();
				user.setUserName(rs.getString(1));
				user.setPassword(rs.getString(2));
				user.setAge(rs.getInt(3));
				user.setSex(rs.getString(4));
				user.setInfo(rs.getString(5));
				user.setPower(rs.getInt(6));
				list.add(user);
			}
			return list;
		}
		catch (SQLException e) 
		{
		    throw new RuntimeException(e);
		}
		finally
		{
			DButil.CloseResource(con,ps,rs);
		}
	}
	public User findbynameandpwd(String username, String password)
	{
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			String sql = "SELECT * FROM user WHERE username=? AND password=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			User user = new User();
			if(rs!=null){
				while(rs.next()){
					user.setUserName(rs.getString(1));
					user.setPassword(rs.getString(2));
					user.setAge(rs.getInt(3));
					user.setSex(rs.getString(4));
					user.setInfo(rs.getString(5));
					user.setPower(rs.getInt(6));
					return user;
				}
			}	
			return null;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally{
			DButil.CloseResource(con, ps, rs);
		}
	}


}
