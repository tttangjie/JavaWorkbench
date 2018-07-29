package Student_Achievement;

import java.io.IOException;
import java.util.Scanner;

public class MainStu {
	Scanner in = new Scanner(System.in);
	public static void main(String[] args) throws IOException {
		Manage manage=new Manage("Student_Achievement.txt");
		MainStu mas=new MainStu();
		mas.menuStu(manage);
		}
	public void menuStu(Manage manage)
	{
		System.out.print("\n**********学生成绩 查询系统**********\n"+
	                       "*---------1.学生信息查询-----------*\n"+
	                       "*---------2.教师账号登陆-----------*\n"+
				           "*---------3.退出查询系统-----------*\n"+
				           "*请输入你想选择的功能：");
		int choice=Integer.parseInt(in.nextLine());
		switch(choice){
		case 1:
			System.out.print("\n请输学生学号或姓名以查询成绩！\n"
					+"学号/姓名：");
			//in.nextLine();
			String info=in.nextLine();
			if(manage.search(manage.file,info)==0)
				System.out.println("信息查询失败！");
			menuStu(manage);
			break;
		case 2: 
			System.out.println("教师账号登陆！");
			try {
				boolean flag=manage.login();
				if(flag==false)
				{
					System.out.println("登陆失败，请重新登陆！");
					flag=manage.login();
				}
				System.out.println("管理员已成功登陆！");
				menuAdmin(manage);
			} catch (IOException e) {
				 e.printStackTrace();
			}
			break;
		case 3:{
			System.out.println("\n已成功退出系统！");
			in.close();
			System.exit(0);
		}
		default:
			System.out.println("请输入正确序号！");
		}
		//in.close();
	}
	public void menuAdmin(Manage manage)
	{
		System.out.print("\n**********学生成绩 管理系统*********\n"+
	                       "*---------1.学生信息列表-----------*\n"+
	                       "*---------2.学生信息添加-----------*\n"+
	                       "*---------3.学生信息删除-----------*\n"+
	                       "*---------4.学生信息修改-----------*\n"+
	                       "*---------5.奖学金名单表-----------*\n"+
	                       "*---------6.退出查询系统-----------*\n"+
				           "*请输入你想选择的功能：");
		int choice=Integer.parseInt(in.nextLine());
		switch(choice)
		{
		case 1:
			System.out.println("\n姓名\t学号\t院系\t专业\t高数\t英语\t体育\t专业1\t专业2\t总分\t平均分\n");
			manage.list(manage.file);
			menuAdmin(manage);
			break;
		case 2:
			manage.input(manage.file, manage.stu);
			menuAdmin(manage);
			break;
		case 3:
			System.out.println("\n输入学生姓名或学号以进行删除！");
			System.out.print("姓名/学号:");
			//in.nextLine();
			String info=in.nextLine();
			try {
				manage.delete(manage.file, info, manage.stu);
			} catch (Exception e) {
				e.printStackTrace();
			}

			menuAdmin(manage);
			break;
		case 4:
			System.out.println("\n输入学生姓名或学号以进行修改！");
			System.out.print("姓名/学号:");
			//in.nextLine();
			String information=in.nextLine();
			try {
				int flag=manage.revise(manage.file, manage.stu, information);
				if(flag==1)
					System.out.println("修改成功！");
				else
					System.out.println("查无此人！");
			} catch (IOException e) {
				e.printStackTrace();
			}
			menuAdmin(manage);
			break;
		case 5:
			System.out.println("\n*---奖学金资格表---*\n"
					+"学院\t姓名\t学号");
			manage.scholarship(manage.file, manage.stu, 3);
			menuAdmin(manage);
			break;
		case 6:
			System.out.println("已成功退出系统！");
			in.close();
			System.exit(0);
			break;
		default:
			System.out.println("请输入正确序号！");
			menuAdmin(manage);
		}
	}
}