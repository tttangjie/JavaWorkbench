package com.mybaties.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybaties.mapper.MedicineMapper;
import com.po.Medicine;

public class MedicineOperate {
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
	public static Medicine findMedicineByMno(String mno)
	{
		SqlSession sqlSession =  sqlSessionFactory.openSession();
		MedicineMapper mapper = sqlSession.getMapper(MedicineMapper.class);
		Medicine medicine=null;
		try
		{
			medicine = mapper.findMedicineByMno(mno);
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.print("not found");
			
			sqlSession.close();
			return null;
		}
		sqlSession.close();
		return medicine;
	}
	public static List<Medicine> findMedicineByMname(String mname)
	{
		SqlSession sqlSession =  sqlSessionFactory.openSession();
		MedicineMapper mapper = sqlSession.getMapper(MedicineMapper.class);
		List<Medicine> list=null;
		try
		{
			list = mapper.findMedicineByMname(mname);
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
	public static void insertMedicine(Medicine medicine)
	{
		SqlSession sqlSession =  sqlSessionFactory.openSession();
		MedicineMapper mapper = sqlSession.getMapper(MedicineMapper.class);
		try
		{
			mapper.insertMedicine(medicine);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			sqlSession.close();
		}
		sqlSession.commit();
		sqlSession.close();
	}
	public static void deleteMedicineByMno(String mno)
	{
		SqlSession sqlSession =  sqlSessionFactory.openSession();
		MedicineMapper mapper = sqlSession.getMapper(MedicineMapper.class);
		try
		{
			mapper.deleteMedicineByMno(mno);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		sqlSession.commit();
		sqlSession.close();
	}
	public static void updateMedicineByMno(Medicine medicine)
	{
		SqlSession sqlSession =  sqlSessionFactory.openSession();
		MedicineMapper mapper = sqlSession.getMapper(MedicineMapper.class);
		try
		{
			mapper.updateMedicineByMno(medicine);
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
		MedicineOperate.deleteMedicineByMno("123");
	}*/

}
