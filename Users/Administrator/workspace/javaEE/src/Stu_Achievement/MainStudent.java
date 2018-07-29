package Stu_Achievement;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class MainStudent {
	static LinkedList<Student> stulist = new LinkedList();
	static LinkedList<Course> courselist = new LinkedList();
	Scanner in = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		Course c1 = new Course("高数", "c1", "王某某");
		Course c2 = new Course("英语", "c2", "孙某某");
		Course c3 = new Course("软件", "c3", "吕某某");
		Course c4 = new Course("体育", "c4", "袁某某");
		courselist.add(c1);
		courselist.add(c2);
		courselist.add(c3);
		courselist.add(c4);
		LinkedList<Course> stucourse1 = new LinkedList();
		stucourse1.add(c1);
		stucourse1.add(c3);
		stulist.add(new Student("055", "tj", "19", "girl", stucourse1));
		LinkedList<Course> stucourse2 = new LinkedList();
		stucourse2.add(c1);
		stucourse2.add(c2);
		stulist.add(new Student("034", "lyx", "19", "girl", stucourse2));

		StudentManager stuma = new StudentManager();
		CourseMangager coursema = new CourseMangager();
		MainStudent mas = new MainStudent();
		mas.stuMenu(stuma, coursema);

	}

	public void stuMenu(StudentManager stuma, CourseMangager coursema) {
		System.out.print("\n********学生信息 管理系统********\n"
				+ "*---------1.增加学生-----------*\n"
				+ "*---------2.修改学生-----------*\n"
				+ "*---------3.删除学生-----------*\n"
				+ "*---------4.查询学生-----------*\n"
				+ "*---------5.打印学生-----------*\n"
				+ "*---------6.课程管理-----------*\n"
				+ "*---------7.系统退出-----------*\n" 
				+ "*请输入你想选择的功能：");
		int choice = Integer.parseInt(in.nextLine());
		switch (choice) {
		case 1:
			System.out.println("*学生信息添加");
			stuma.add(in);
			stuMenu(stuma, coursema);
			break;
		case 2:
			System.out.println("*请输入学生学号以进行修改");
			stuma.modify(in.nextLine(),in);
			stuMenu(stuma, coursema);
			break;
		case 3:
			System.out.println("*请输入学生学号以进行删除");
			stuma.delete(in.nextLine());
			stuMenu(stuma, coursema);
			break;
		case 4:
			System.out.println("*请输入学生学号以进行查询");
			stuma.seek(in.nextLine());
			stuMenu(stuma, coursema);
			break;
		case 5:
			System.out.println("*所有学生信息如下：");
			stuma.list();
			stuMenu(stuma, coursema);
			break;
		case 6:
			courseMenu(stuma,coursema);
			break;
		case 7:
			System.out.println("\n已成功退出系统！");
			// in.close();
			System.exit(0);
			break;
		default:
			System.out.println("请输入正确序号！");
			stuMenu(stuma, coursema);
		}
	}

	public void courseMenu(StudentManager stuma,CourseMangager coursema) {
		System.out.print("\n********课程信息 管理系统********\n"
				+ "*---------1.增加课程-----------*\n"
				+ "*---------2.修改课程-----------*\n"
				+ "*---------3.删除课程-----------*\n"
				+ "*---------4.打印课程-----------*\n"
				+ "*-----5.查询学生选课情况-------*\n" 
				+ "*-----6.打印课程下学生信息-----*\n"
				+ "*-------7.添加选课的学生 -------*\n"
				+ "*-------8.删除选课的学生 -------*\n"
				+ "*-------9.返回上级菜单---------*\n" 
				+ "*请输入你想选择的功能：");
		int choice = Integer.parseInt(in.nextLine());
		switch (choice) {
		case 1:
			coursema.add(in);
			courseMenu(stuma,coursema);
			break;
		case 2:
			System.out.println("*请输入需要修改的课程的课程号");
			coursema.modify(in.nextLine(),in);
			courseMenu(stuma,coursema);
			break;
		case 3:
			System.out.println("*请输入需要删除的课程的课程号");
			coursema.delete(in.nextLine());
			courseMenu(stuma,coursema);
			break;
		case 4:
			System.out.println("*课程列表如下");
			coursema.list();
			courseMenu(stuma,coursema);
			break;
		case 5:
			System.out.println("*请输入需要查询的学生的学号");
			coursema.stuCourse(in.nextLine());
			courseMenu(stuma,coursema);
			break;
		case 6:
			System.out.println("*请输入课程号");
			coursema.listStu(in.nextLine());
			courseMenu(stuma,coursema);
			break;
		case 7:
			System.out.println("*请依次输入课程号和学生学号");
			coursema.courseAddStu(in.nextLine(), in.nextLine());
			courseMenu(stuma,coursema);
			break;
		case 8:
			System.out.println("*请依次输入课程号和学生学号");
			coursema.courseDeleteStu(in.nextLine(), in.nextLine());
			courseMenu(stuma,coursema);
			break;
		case 9:
			stuMenu(stuma, coursema);
			break;
		}
	}
}
