package com.mybaties.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybaties.mapper.DoctorMapper;
import com.po.Doctor;

public class DoctorOperate {
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
	public static Doctor findDoctorByDno(String dno)
	{
		SqlSession sqlSession =  sqlSessionFactory.openSession();
		DoctorMapper mapper = sqlSession.getMapper(DoctorMapper.class);
		Doctor doctor=null;
		try
		{
			doctor = mapper.findDoctorByDno(dno);
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.print("not found");
			
			sqlSession.close();
			return null;
		}
		sqlSession.close();
		return doctor;
	}
	public static List<Doctor> findDoctorByDname(String dname)
	{
		SqlSession sqlSession =  sqlSessionFactory.openSession();
		DoctorMapper mapper = sqlSession.getMapper(DoctorMapper.class);
		List<Doctor> list=null;
		try
		{
			list = mapper.findDoctorByDname(dname);
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
	// show all doctors infomation
	public static List<Doctor> findAllDoctor()
	{
		SqlSession sqlSession =  sqlSessionFactory.openSession();
		DoctorMapper mapper = sqlSession.getMapper(DoctorMapper.class);
		List<Doctor> list=null;
		try
		{
			list = mapper.findAllDoctor();
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
	public static void insertDoctor(Doctor doctor)
	{
		SqlSession sqlSession =  sqlSessionFactory.openSession();
		DoctorMapper mapper = sqlSession.getMapper(DoctorMapper.class);
		try
		{
			mapper.insertDoctor(doctor);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		sqlSession.commit();
		sqlSession.close();
	}
	public static void deleteDoctorByDno(String dno)
	{
		SqlSession sqlSession =  sqlSessionFactory.openSession();
		DoctorMapper mapper = sqlSession.getMapper(DoctorMapper.class);
		try
		{
			mapper.deleteDoctorByDno(dno);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		sqlSession.commit();
		sqlSession.close();
	}
	public static void updateDoctorByDno(Doctor doctor)
	{
		SqlSession sqlSession =  sqlSessionFactory.openSession();
		DoctorMapper mapper = sqlSession.getMapper(DoctorMapper.class);
		try
		{
			mapper.updateDoctorByDno(doctor);
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
		Doctor doctor=new Doctor();
		doctor.setDage("18");
		doctor.setDepno("dep01");
		doctor.setDid("123456789101112131");
		doctor.setDname("whatever");
		doctor.setDno("123");
		doctor.setDsex("Ů");
		doctor.setDtel("13260905153");
		DoctorOperate.insertDoctor(doctor);
	}*/

}
