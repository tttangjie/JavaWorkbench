package Stu_Achievement;

import java.util.LinkedList;
import java.util.Scanner;

public class CourseMangager {
	LinkedList<Course> courselist = MainStudent.courselist;
	LinkedList<Student> stulist = MainStudent.stulist;

	// 增加课程
	public void add(Scanner sc) {
		//Scanner sc = new Scanner(System.in);
		System.out.println("输入课程号：");
		String cnum = sc.nextLine();
		System.out.println("输入课程名：");
		String cname = sc.nextLine();
		System.out.println("输入教师名：");
		String teacher = sc.nextLine();
		if (cnum == null) {
			System.out.println("课程信息添加失败！");
			return;
		}
		courselist.add(new Course(cnum, cname, teacher));
		System.out.println("课程信息添加成功！");
	}

	// 修改课程
	public void modify(String cnum,Scanner sc) {
		//Scanner sc = new Scanner(System.in);
		for (int i = 0; i < courselist.size(); i++) {
			if (courselist.get(i).getCnum().equals(cnum)) {
				System.out.println("输入课程名：");
				courselist.get(i).setCname(sc.nextLine());
				System.out.println("输入教师名：");
				courselist.get(i).setTeacher(sc.nextLine());
				System.out.println("课程信息修改成功");
				return;
			}
		}
		System.out.println("未找到此课程！");
	}

	// 删除课程信息
	public void delete(String cnum) {
		for (int i = 0; i < courselist.size(); i++) {
			if (courselist.get(i).getCnum().equals(cnum)) {
				courselist.remove(i);
				System.out.println("课程信息删除成功！");
				return;
			}
		}
		System.out.println("未找到此课程！");
	}

	// 打印课程信息
	public void list() {
		if (courselist.size() == 0) {
			System.out.println("暂无课程数据！");
			return;
		}
		for (int i = 0; i < courselist.size(); i++) {
			System.out.println(courselist.get(i).toString());
		}
	}

	// 通过学生学号，查询该学生选课情况
	public void stuCourse(String num) {
		for (int i = 0; i < stulist.size(); i++) {
			if (stulist.get(i).getNum().equals(num)) {
				for (int j = 0; j < stulist.get(i).getCs().size(); j++)
					System.out.println(stulist.get(i).getCs().get(j));
				return;
			}
		}
		System.out.println("未查询到该学生选课信息！");
	}

	// 通过课程号，打印当前课程下面学生信息
	public void listStu(String cnum) {
		for (int i = 0; i < stulist.size(); i++) {
			for (int j = 0; j < stulist.get(i).getCs().size(); j++) {
				if (stulist.get(i).getCs().get(j).getCnum().equals(cnum)) {
					System.out.println(stulist.get(i).toString());
					break;
				}
			}
		}
	}

	// 添加选这门课程的学生
	public void courseAddStu(String cnum, String num) {
		int flag=-1;
		for (int j = 0; j < stulist.size(); j++) {
			if (stulist.get(j).getNum().equals(num)) {
				for (int i = 0; i < courselist.size(); i++) {
					if (courselist.get(i).getCnum().equals(cnum)) {
						stulist.get(j).getCs().add(courselist.get(i));
						System.out.println("已成功添加选这门课程的学生！");
						flag=1;
					}
				}
			}
		}
		if(flag<0)
			System.out.println("未成功添加！");
	}
	
	//删除选这门课程的学生
	public void courseDeleteStu(String cnum,String num){
		int flag=-1;
		for (int j = 0; j < stulist.size(); j++) {
			if (stulist.get(j).getNum().equals(num)) {
				for (int i = 0; i < stulist.get(j).getCs().size(); i++) {
					if (stulist.get(j).getCs().get(i).getCnum().equals(cnum)) {
						stulist.get(j).getCs().remove(i);
						flag=1;
					}
				}
			}
		}
		if(flag<0)
			System.out.println("未成功删除！");
	}
}
