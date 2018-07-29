package com.mybaties.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybaties.mapper.PrepayMapper;
import com.po.Prepay;

public class PrepayOperate {
	private static SqlSessionFactory sqlSessionFactory=null;
	static 
	{
		String res="SqlMapConfig.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(res);
			 sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Prepay findPrepayByPno(String pno)
	{
		SqlSession sqlSession =  sqlSessionFactory.openSession();
		PrepayMapper mapper = sqlSession.getMapper(PrepayMapper.class);
		Prepay prepay=null;
		try
		{
			prepay = mapper.findPrepayByPno(pno);
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.print("not found");
			
			sqlSession.close();
			return null;
		}
		sqlSession.close();
		return prepay;
	}
	public static void insertPrepay(Prepay prepay)
	{
		SqlSession sqlSession =  sqlSessionFactory.openSession();
		PrepayMapper mapper = sqlSession.getMapper(PrepayMapper.class);
		try
		{
			mapper.insertPrepay(prepay);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			sqlSession.close();
		}
		sqlSession.commit();
		sqlSession.close();
	}
	public static void deletePrepayByPno(String pno)
	{
		SqlSession sqlSession =  sqlSessionFactory.openSession();
		PrepayMapper mapper = sqlSession.getMapper(PrepayMapper.class);
		try
		{
			mapper.deletePrepayByPno(pno);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		sqlSession.commit();
		sqlSession.close();
	}
	public static void updatePrepayByPno(Prepay prepay)
	{
		SqlSession sqlSession =  sqlSessionFactory.openSession();
		PrepayMapper mapper = sqlSession.getMapper(PrepayMapper.class);
		try
		{
			mapper.updatePrepayById(prepay);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			sqlSession.close();
		}
		sqlSession.commit();
		sqlSession.close();
	}
/*	public static void main(String args[])
	{
		 
	}*/

}
