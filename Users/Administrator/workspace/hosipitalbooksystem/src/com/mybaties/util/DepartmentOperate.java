package com.mybaties.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybaties.mapper.DepartmentMapper;
import com.po.Department;

public class DepartmentOperate {
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
	public static Department findDepartmentByDepno(String depno)
	{
		SqlSession sqlSession =  sqlSessionFactory.openSession();
		DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
		Department department=null;
		try
		{
			department = mapper.findDepartmentByDepno(depno);
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.print("not found");
			
			sqlSession.close();
			return null;
		}
		sqlSession.close();
		return department;
	}
	public static List<Department> findDepartmentByDepname(String depname)
	{
		SqlSession sqlSession =  sqlSessionFactory.openSession();
		DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
		List<Department> list=null;
		try
		{
			list = mapper.findDepartmentByDepname(depname);
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
	public static void insertDepartment(Department department)
	{
		SqlSession sqlSession =  sqlSessionFactory.openSession();
		DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
		try
		{
			mapper.insertDepartment(department);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			sqlSession.close();
		}
		sqlSession.commit();
		sqlSession.close();
	}
	public static void deleteDepartmentByDepno(String depno)
	{
		SqlSession sqlSession =  sqlSessionFactory.openSession();
		DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
		try
		{
			mapper.deleteDepartmentByDepno(depno);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		sqlSession.commit();
		sqlSession.close();
	}
	public static void updateDepartmentByDepno(Department Department)
	{
		SqlSession sqlSession =  sqlSessionFactory.openSession();
		DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
		try
		{
			mapper.updateDepartmentByDepno(Department);
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
		Department Department=null;
		Department = findDepartmentByDepno("123");
		if(Department!=null)
		{
			System.out.println(Department.toString());
		}
	}*/

}
