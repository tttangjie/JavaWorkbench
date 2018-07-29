package Stu_Achievement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ArrayStu {
	public ArrayStu(){
		
	}
	public ArrayStu(File file,Student stu[])throws Exception
	{
		FileReader fr=new FileReader(file);
		BufferedReader br=new BufferedReader(fr);
		String contain=br.readLine();
		while(contain!=null)
		{
			String[] arrs=contain.split("\t");
			int j=0;
			stu[MainStu.count]=new Student();
			stu[MainStu.count].setName(arrs[j++]);
			stu[MainStu.count].setNumber(arrs[j++]);
			stu[MainStu.count].setDepartment(arrs[j++]);
			stu[MainStu.count].setSpeciality(arrs[j++]);
			stu[MainStu.count].setMath( Integer.parseInt(arrs[j++]));
			stu[MainStu.count].setEnglish( Integer.parseInt(arrs[j++]));
			stu[MainStu.count].setPE( Integer.parseInt(arrs[j++]));
			stu[MainStu.count].setMajor_1( Integer.parseInt(arrs[j++]));
			stu[MainStu.count].setMajor_2( Integer.parseInt(arrs[j++]));
			stu[MainStu.count].average();
			MainStu.count++;
			contain=br.readLine();
		}
		br.close();
	}	
}
