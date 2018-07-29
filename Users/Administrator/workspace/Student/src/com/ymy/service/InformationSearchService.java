package com.ymy.service;

import java.util.List;

import com.ymy.pojo.Course;
import com.ymy.pojo.School;
import com.ymy.pojo.Student;

public interface InformationSearchService {
	public List<School> schoolList();
	public List<Course> courseList();
	public List<Student> studentList();
}
