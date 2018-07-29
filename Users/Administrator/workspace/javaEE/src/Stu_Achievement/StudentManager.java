package Stu_Achievement;

import java.util.LinkedList;
import java.util.Scanner;

public class StudentManager {
	LinkedList<Student> stulist = MainStudent.stulist;
	LinkedList<Course> courselist = MainStudent.courselist;

	// 增加学生信息
	public void add(Scanner sc) {
		//Scanner sc = new Scanner(System.in);
		System.out.println("输入学生学号：");
		String num = sc.nextLine();

		for (int j = 0;; j++) {
			int flag = -1;
			for (int i = 0; i < stulist.size(); i++) {
				if (stulist.get(i).getNum().equals(num)) {
					System.out.println("学号重复请重新输入！");
					flag = 1;
				}
			}
			if (flag < 0)
				break;
			num = sc.nextLine();
		}
		System.out.println("输入学生姓名：");
		String name = sc.nextLine();
		System.out.println("输入学生年龄：");
		String age = sc.nextLine();
		System.out.println("输入学生性别：");
		String sex = sc.nextLine();
		System.out.println("输入课程号（以#结束）：");
		String course = sc.nextLine();
		LinkedList<Course> cnolist = new LinkedList<Course>();

		while (!course.equals("#")) {
			int j = -1;
			for (int i = 0; i < courselist.size(); i++) {
				// System.out.println(courselist.get(i).getCnum());
				if (courselist.get(i).getCnum().equals(course)) {
					cnolist.add(courselist.get(i));
					j = i;
				}
			}
			if (j < 0)
				System.out.println("无此课程信息！");
			course = sc.nextLine();
		}
		if (num == null) {
			System.out.println("学生信息添加失败！");
			return;
		}
		stulist.add(new Student(num, name, age, sex, cnolist));
		System.out.println("学生信息添加成功！");
	}

	// 修改学生信息
	public void modify(String num,Scanner sc) {
		//Scanner sc = new Scanner(System.in);
		for (int i = 0; i < stulist.size(); i++) {
			if (stulist.get(i).getNum().equals(num)) {
				System.out.println("输入学生姓名：");
				String name = sc.nextLine();
				System.out.println("输入学生年龄：");
				String age = sc.nextLine();
				System.out.println("输入学生性别：");
				String sex = sc.nextLine();
				System.out.println("输入课程号（以#结束）：");
				String course = sc.nextLine();
				LinkedList<Course> cnolist = new LinkedList<Course>();
				while (!course.equals("#")) {
					int j = -1;
					for (int k = 0; k < courselist.size(); k++) {
						if (courselist.get(k).getCnum().equals(course)) {
							cnolist.add(courselist.get(k));
							j = k;
						}
					}
					if (j < 0)
						System.out.println("无此课程信息！");
					course = sc.nextLine();
				}
				stulist.get(i).setName(name);
				stulist.get(i).setAge(age);
				stulist.get(i).setSex(sex);
				stulist.get(i).setCs(cnolist);
				System.out.println("学生信息修改成功！");
				return;
			}
		}
		System.out.println("未找到该学生！");
	}

	// 删除学生信息
	public void delete(String num) {
		for (int i = 0; i < stulist.size(); i++) {
			if (stulist.get(i).getNum().equals(num)) {
				stulist.remove(i);
				System.out.println("学生信息删除成功！");
				return;
			}
		}
		System.out.println("未找到该学生！");
	}

	// 查询学生信息
	public void seek(String num) {
		for (int i = 0; i < stulist.size(); i++) {
			if (stulist.get(i).getNum().equals(num)) {
				System.out.println("学生信息查找如下：");
				System.out.println(stulist.get(i).toString());
				return;
			}
		}
		System.out.println("未找到该学生！");
	}

	// 打印学生信息
	public void list() {
		if (stulist.size() == 0) {
			System.out.println("暂无学生数据！");
			return;
		}
		for (int i = 0; i < stulist.size(); i++) {
			System.out.println(stulist.get(i).toString());
		}
	}
}
