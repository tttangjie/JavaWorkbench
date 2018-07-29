package com.ymy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ymy.mapper.InformationSearchMapper;
import com.ymy.pojo.Course;
import com.ymy.pojo.School;
import com.ymy.pojo.Student;
import com.ymy.service.InformationSearchService;
@Service
public class InformationServiceImpl implements InformationSearchService{
	@Autowired
	InformationSearchMapper informsearchmapper;

	@Override
	public List<School> schoolList() {
		// TODO Auto-generated method stub
		return informsearchmapper.schoolList();
	}

	@Override
	public List<Course> courseList() {
		// TODO Auto-generated method stub
		return informsearchmapper.courseList();
	}

	@Override
	public List<Student> studentList() {
		// TODO Auto-generated method stub
		return informsearchmapper.studentList();
	}
	
}
