package Stu_Achievement;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class InputStu {
	Scanner in=new Scanner(System.in);
	public InputStu()
	{
		
	}
	public InputStu(int count,File file,Student stu[])throws IOException
	{
		BufferedWriter bw=null;
		try{
			FileWriter fw=new FileWriter(file, true);
			bw=new BufferedWriter(fw);
			stu[count]=new Student();
			System.out.print("输入学生姓名：");
			stu[count].setName(in.nextLine());
			System.out.print("输入学生学号：");
			stu[count].setNumber(in.nextLine());
			System.out.print("输入学生院系：");
			stu[count].setDepartment(in.nextLine());
			System.out.print("输入学生专业：");
			stu[count].setSpeciality(in.nextLine());
			System.out.print("输入学生高数成绩：");
			stu[count].setMath(in.nextInt());
			System.out.print("输入学生英语成绩：");
			stu[count].setEnglish(in.nextInt());
			System.out.print("输入学生体育成绩：");
			stu[count].setPE(in.nextInt());
			System.out.print("输入学生专业1成绩：");
			stu[count].setMajor_1(in.nextInt());
			System.out.print("输入学生专业2成绩：");
			stu[count].setMajor_2(in.nextInt());
			bw.write(stu[count].toString());
			bw.newLine();
			bw.close();
			MainStu.count++;
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}
