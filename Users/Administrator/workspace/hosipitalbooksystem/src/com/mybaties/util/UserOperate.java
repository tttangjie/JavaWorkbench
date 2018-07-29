package com.mybaties.util;

import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.mybaties.mapper.UserMapper;
import com.po.User;

public class UserOperate  {
	private static SqlSessionFactory sessionFactory=null ;
	static
	{
		String res="SqlMapConfig.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(res);
			 sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static UserMapper getMapper(SqlSession sqlSession )throws Exception
	{
		 UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		 return mapper;
	}
	private static SqlSession getSqlSession()throws Exception
	{
		SqlSession sqlSession =  sessionFactory.openSession();
		return sqlSession;
	}

	public static User findUser(String id)throws Exception // 返回值为实体类
	{
		
		SqlSession sqlSession = getSqlSession();
		User  user= getMapper(sqlSession).findUserById(id);
		sqlSession.close();
		return user;
	}
	public static void insertUser(User user)throws Exception
	{
		SqlSession sqlSession = getSqlSession();
		 getMapper(sqlSession).insertUserInfo(user);
		 sqlSession.commit();
		 sqlSession.close();
		
	}
	public static void deleteUserById(String id)throws Exception
	{
		SqlSession sqlSession = getSqlSession();
		getMapper(sqlSession).deleteUserById(id);
		sqlSession.commit();
		 sqlSession.close();
	}
	
	public static void updateUserInfo(User user)throws Exception
	{
		SqlSession sqlSession = getSqlSession();
		getMapper(sqlSession).updateUserById(user);
		sqlSession.commit();
		sqlSession.close();
	}
	//this code just a test
/*    public static void main(String args[]) throws Exception
	{
		try {
			System.out.println(findUser("123").toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		deleteUserById("123");
		User user = new User();
		user.setId("444");
		user.setPwd("567");
		insertUser(user);
		//  重复添加或者删除等会造成异常，可以通过异常处理解决
		 
	}*/
	

}
