package com.mybaties.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybaties.mapper.PatientMapper;
import com.po.Patient;

public class PatientOperate {
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
	public static Patient findPatientByPno(String pno)
	{
		SqlSession sqlSession =  sqlSessionFactory.openSession();
		PatientMapper mapper = sqlSession.getMapper(PatientMapper.class);
		Patient Patient=null;
		try
		{
			Patient = mapper.findPatientByPno(pno);
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.print("not found");
			
			sqlSession.close();
			return null;
		}
		sqlSession.close();
		return Patient;
	}
	public static void insertPatient(Patient patient)
	{
		SqlSession sqlSession =  sqlSessionFactory.openSession();
		PatientMapper mapper = sqlSession.getMapper(PatientMapper.class);
		try
		{
			mapper.insertPatient(patient);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			sqlSession.close();
		}
		sqlSession.commit();
		sqlSession.close();
	}
	public static void deletePatientByPno(String pno)
	{
		SqlSession sqlSession =  sqlSessionFactory.openSession();
		PatientMapper mapper = sqlSession.getMapper(PatientMapper.class);
		try
		{
			mapper.deletePatientByPno(pno);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		sqlSession.commit();
		sqlSession.close();
	}
	public static void updatePatientByPno(Patient patient)
	{
		SqlSession sqlSession =  sqlSessionFactory.openSession();
		PatientMapper mapper = sqlSession.getMapper(PatientMapper.class);
		try
		{
			mapper.updatePatientByPno(patient);
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
		 Patient p = findPatientByPno("111");
		 if(p!=null)
		 {
			 System.out.print(p.toString());
		 }
	}*/

}
