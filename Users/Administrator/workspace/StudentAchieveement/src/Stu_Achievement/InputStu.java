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
			System.out.print("����ѧ��������");
			stu[count].setName(in.nextLine());
			System.out.print("����ѧ��ѧ�ţ�");
			stu[count].setNumber(in.nextLine());
			System.out.print("����ѧ��Ժϵ��");
			stu[count].setDepartment(in.nextLine());
			System.out.print("����ѧ��רҵ��");
			stu[count].setSpeciality(in.nextLine());
			System.out.print("����ѧ�������ɼ���");
			stu[count].setMath(in.nextInt());
			System.out.print("����ѧ��Ӣ��ɼ���");
			stu[count].setEnglish(in.nextInt());
			System.out.print("����ѧ�������ɼ���");
			stu[count].setPE(in.nextInt());
			System.out.print("����ѧ��רҵ1�ɼ���");
			stu[count].setMajor_1(in.nextInt());
			System.out.print("����ѧ��רҵ2�ɼ���");
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
