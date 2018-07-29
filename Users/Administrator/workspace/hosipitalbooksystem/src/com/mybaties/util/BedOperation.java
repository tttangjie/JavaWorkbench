package com.mybaties.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.mybaties.mapper.BedMapper;
import com.po.Bed;

public class BedOperation {
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
	public static Bed findBedByBno(String bno)
	{
		SqlSession sqlSession =  sqlSessionFactory.openSession();
		BedMapper mapper = sqlSession.getMapper(BedMapper.class);
		Bed bed=null;
		try
		{
			bed = mapper.findBedByBno(bno);
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.print("not found");
			
			sqlSession.close();
			return null;
		}
		sqlSession.close();
		return bed;
	}
	public static List<Bed> findBedByCondition(int condition)
	{
		SqlSession sqlSession =  sqlSessionFactory.openSession();
		BedMapper mapper = sqlSession.getMapper(BedMapper.class);
		List<Bed> list=null;
		try
		{
			list = mapper.findBedByCondition(condition);
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.print("not found");
			
			sqlSession.close();
			return null;
		}
		sqlSession.close();
		return list;
	}
	public static void insertBed(Bed bed)
	{
		SqlSession sqlSession =  sqlSessionFactory.openSession();
		BedMapper mapper = sqlSession.getMapper(BedMapper.class);
		try
		{
			mapper.insertBed(bed);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			
			sqlSession.commit();
		    sqlSession.close();
		}
		
	}
	public static void deleteBedByBno(String bno)
	{
		SqlSession sqlSession =  sqlSessionFactory.openSession();
		BedMapper mapper = sqlSession.getMapper(BedMapper.class);
		try
		{
			mapper.deleteBedByBno(bno);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		sqlSession.commit();
		sqlSession.close();
	}
	public static void updateBedByBno(Bed bed)
	{
		SqlSession sqlSession =  sqlSessionFactory.openSession();
		BedMapper mapper = sqlSession.getMapper(BedMapper.class);
		try
		{
			mapper.updateBedByBno(bed);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			sqlSession.close();
		}
		sqlSession.commit();
		sqlSession.close();
	}
	/*public static void main(String args[])
	{
		Bed bed=new Bed();
		
		bed.setBno("b03");
		bed.setCondition("0");
		bed.setBprice(400);
		
		BedOperation.insertBed(bed);
	}*/

}
