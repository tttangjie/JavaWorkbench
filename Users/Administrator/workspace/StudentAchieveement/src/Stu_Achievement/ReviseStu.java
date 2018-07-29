package Stu_Achievement;

import java.io.*;
import java.util.Scanner;

public class ReviseStu {
	Scanner in=new Scanner(System.in);
	public ReviseStu()
	{
		
	}
	public ReviseStu(File file,Student stu[],String info)throws IOException{
		try {
			FileReader fr=new FileReader( file);
			BufferedReader br=new BufferedReader(fr);
			StringBuffer sb=new StringBuffer(4096);
			String contain=null;
			int i=0;
			while((contain=br.readLine())!=null)
			{
				if(contain.contains(info))
				{
					System.out.println(contain);
					System.out.println("请输入修改后的数据");
					stu[i]=new Student();
					System.out.print("输入学生姓名：");
					stu[i].setName(in.nextLine());
					System.out.print("输入学生学号：");
					stu[i].setNumber(in.nextLine());
					System.out.print("输入学生院系：");
					stu[i].setDepartment(in.nextLine());
					System.out.print("输入学生专业：");
					stu[i].setSpeciality(in.nextLine());
					System.out.print("输入学生高数成绩：");
					stu[i].setMath(in.nextInt());
					System.out.print("输入学生英语成绩：");
					stu[i].setEnglish(in.nextInt());
					System.out.print("输入学生体育成绩：");
					stu[i].setPE(in.nextInt());
					System.out.print("输入学生专业1成绩：");
					stu[i].setMajor_1(in.nextInt());
					System.out.print("输入学生专业2成绩：");
					stu[i].setMajor_2(in.nextInt());
					contain=stu[i].toString();
				}
				sb.append(contain).append("\r\n");
				i++;
			}
			br.close();
			FileWriter fw=new FileWriter( file);
			BufferedWriter bw=new BufferedWriter(fw);
			bw.write(sb.toString());
			bw.close();
			}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
