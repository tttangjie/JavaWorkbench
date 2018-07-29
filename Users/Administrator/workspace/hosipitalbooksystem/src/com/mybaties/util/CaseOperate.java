package com.mybaties.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybaties.mapper.CaseMapper;
import com.po.MedicalCase;

public class CaseOperate {
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
	public static MedicalCase findcaseByPno(String pno)
	{
		SqlSession sqlSession =  sqlSessionFactory.openSession();
		CaseMapper mapper = sqlSession.getMapper(CaseMapper.class);
		MedicalCase ca=null;
		try
		{
			ca = mapper.findCaseByPno(pno);
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.print("not found");
			
			sqlSession.close();
			return null;
		}
		sqlSession.close();
		return ca;
	}

	public static void insertCase(MedicalCase ca)
	{
		SqlSession sqlSession =  sqlSessionFactory.openSession();
		CaseMapper mapper = sqlSession.getMapper(CaseMapper.class);
		try
		{
			mapper.insertCase(ca);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			sqlSession.close();
		}
		sqlSession.commit();
		sqlSession.close();
	}
	public static void deleteCaseByPno(String pno)
	{
		SqlSession sqlSession =  sqlSessionFactory.openSession();
		CaseMapper mapper = sqlSession.getMapper(CaseMapper.class);
		try
		{
			mapper.deleteCaseByPno(pno);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		sqlSession.commit();
		sqlSession.close();
	}
	public static void updateCaseByPno(MedicalCase ca)
	{
		SqlSession sqlSession =  sqlSessionFactory.openSession();
		CaseMapper mapper = sqlSession.getMapper(CaseMapper.class);
		try
		{
			mapper.updateCaseByPno(ca);
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
		MedicalCase bed=new MedicalCase();
		
		bed.setPno("p001");
		bed.setDno("d01");
		bed.setMno("m01");
		bed.setBno("b02");
	//	bed.setDay("2");
		CaseOperate.insertCase(bed);
	}*/
}
