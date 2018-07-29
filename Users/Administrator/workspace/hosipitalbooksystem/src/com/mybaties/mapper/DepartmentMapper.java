package com.mybaties.mapper;

import java.util.List;

import com.po.Department;

public interface DepartmentMapper {
	public Department findDepartmentByDepno(String depno);
	public List<Department> findDepartmentByDepname(String  depname);
	public void insertDepartment(Department department);
	public void deleteDepartmentByDepno(String depno);
	public void updateDepartmentByDepno(Department department);
}
