package com.ymy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ymy.pojo.Course;
import com.ymy.pojo.School;
import com.ymy.pojo.Student;
import com.ymy.service.InformationSearchService;

@Controller
@RequestMapping("/Information")
public class InformationSearchController {
	@Autowired
	InformationSearchService informservice;
	@RequestMapping("/selectStudent.do")
	@ResponseBody
	public List<Student> selectStudent()
	{
		return informservice.studentList();
	}
	@RequestMapping("/selectCourse.do")
	@ResponseBody
	public List<Course> selectCourse()
	{
		return informservice.courseList();
	}
	@RequestMapping("/selectSchool.do")
	@ResponseBody
	public List<School> selectSchool()
	{
		return informservice.schoolList();
	}
}
