package Student_Achievement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Manage {
	static int count=0;//count 为学生人数
	Student stu[]=new Student[500];
	File file=null;
	public Manage(String string)
	{
		file =new File(string);
		if(!file.exists())
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		try {
			arrary(file,stu);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//将文件中的学生信息存入学生对象的数组中
	public static void arrary(File file,Student stu[])throws IOException 
	{
		FileReader fr=new FileReader(file);
		BufferedReader br=new BufferedReader(fr);
		String contain=br.readLine();
		while(contain!=null)
		{
			String[] arrs=contain.split("\t");
			int j=0;
			stu[count]=new Student();
			stu[count].setName(arrs[j++]);
			stu[count].setNumber(arrs[j++]);
			stu[count].setDepartment(arrs[j++]);
			stu[count].setSpeciality(arrs[j++]);
			stu[count].setMath( Integer.parseInt(arrs[j++]));
			stu[count].setEnglish( Integer.parseInt(arrs[j++]));
			stu[count].setPE( Integer.parseInt(arrs[j++]));
			stu[count].setMajor_1( Integer.parseInt(arrs[j++]));
			stu[count].setMajor_2( Integer.parseInt(arrs[j++]));
			stu[count].average();
			count++;
			contain=br.readLine();
		}
		br.close();
	}
	
	//对学生数组以平均分由高到低进行排序，写入文件
	public void sort(File file,Student stu[])
	{
		Student temp=null;
		for(int i=count-1;i>=0;i--)//冒泡排序
		{
			for(int j=i-1;j>=0;j--)
			{
				if(stu[j].getAverage()<stu[i].getAverage())
				{
					temp=stu[i];
					stu[i]=stu[j];
					stu[j]=temp;
				}
			}
		}
		try{
			FileReader fr=new FileReader( file);
			BufferedReader br=new BufferedReader(fr);
			StringBuffer sb=new StringBuffer(4096);
			for(int i=0;i<count;i++)
			{
				sb.append(stu[i].toString()).append("\r\n");	
			}
			try{
				if(br!=null)
					br.close();
			}
			catch (IOException e){
				throw new RuntimeException("fail to close");
			}
			FileWriter fw=new FileWriter( file);
			BufferedWriter bw=new BufferedWriter(fw);
			bw.write(sb.toString());
			bw.close();
		}
		
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	//插入新的学生对象，输出学生信息；
	public void input(File file,Student stu[])
	{
		@SuppressWarnings("resource")
		Scanner in=new Scanner(System.in);
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
			count++;
		}
		catch(IOException e){
			e.printStackTrace();
		}
		System.out.println("信息添加成功！");
		System.out.println(stu[count-1].toString());
		sort(file,stu);
	}
	
	//输入学生学号或姓名 删除学生信息，输出删除的学生信息的字符串
	public void delete(File file,String info,Student stu[])throws Exception
	{
		try {
			FileReader fr=new FileReader(file);
			BufferedReader br=new BufferedReader(fr);
			StringBuffer sb=new StringBuffer();
			String contain=null;
			while((contain=br.readLine())!=null)
			{
				if(contain.contains(info))
				{
					System.out.println(contain);
					System.out.println("已成功删除！");
					continue;
				}
					sb.append(contain).append("\r\n");	
			}
			arrary(file,stu);
			try{
				if(br!=null)
					br.close();
			}
			catch (IOException e){
				throw new RuntimeException("fail to close");
			}
			FileWriter fw=new FileWriter( file);
			BufferedWriter bw=new BufferedWriter(fw);
			bw.write(sb.toString());
			bw.close();
			}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//输入学生姓名或学号，输出学生信息
	public int search(File file,String info)
	{
		BufferedReader br=null;
		int flag=0;
		try{
			FileReader fr=new FileReader(file);
			br=new BufferedReader(fr);
			String contain=br.readLine();
			while(contain!=null){
				if(contain.contains(info)){
					System.out.println(contain);
					flag=1;
				}
				contain=br.readLine();
			}
		}
		catch(IOException e){
			throw new RuntimeException("Read Information fail");
		}
		finally{
			try{
				if(br!=null)
					br.close();
			}
			catch (IOException e){
				throw new RuntimeException("fail to close");
				}
		}
		return flag;
	}
	
	//列出学生清单
	public void list(File file)
	{
		BufferedReader br=null;
		try{
			FileReader fr=new FileReader(file);
			br=new BufferedReader(fr);
			String contain=br.readLine();
			while(contain!=null){
					System.out.println(contain);
					contain=br.readLine();
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			try{
				if(br!=null)
					br.close();
			}
			catch (IOException e){
				throw new RuntimeException("fail to close");
			}
		}
	}
	
	//修改学生信息，输入学生信息以定位需要修改信息的学生
	//在屏幕上显示修改后的学生信息
	public int revise(File file,Student stu[],String info)throws IOException
	{
		@SuppressWarnings("resource")
		Scanner in=new Scanner(System.in);
		int flag=0;
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
					System.out.println(contain);
					flag=1;
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
		sort(file,stu);
		return flag;
	}
	
	//管理员账号密码查询
	public boolean query(File file,String info)
	{
		BufferedReader br=null;
		try{
			FileReader fr=new FileReader(file);
			br=new BufferedReader(fr);
			String contain=br.readLine();
			while(contain!=null){
				if(contain.equals(info)){
					return true;
				}
				contain=br.readLine();
			}
			return false;
		}
		catch(IOException e){
			throw new RuntimeException("Read Information fail");
		}
		finally{
			try{
				if(br!=null)
					br.close();
			}
			catch (IOException e){
				throw new RuntimeException("fail to close");
				}
		}
	}
	
	//奖学金资格人数
	public void scholarship(File file,Student stu[],int num)
	{
		for(int i=0;i<num&&i<count;i++)
		{
			System.out.println(stu[i].getDepartment()+"\t"+stu[i].getName()+"\t"+stu[i].getNumber());
		}
	}
	
	//管理员通过密码登录
	//管理员用户名,密码存储在login.txt中
	public boolean login()throws IOException
	{
		File fileL =new File("login.txt");
		if(!fileL.exists())
			try {
				fileL.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		@SuppressWarnings("resource")
		Scanner in=new Scanner(System.in);
		String username=null,password=null;
		StringBuffer sb=new StringBuffer(4096);
		System.out.print("用户名：");
		username=in.nextLine();
		sb.append(username).append(" ");
		System.out.print("密码:");
		password=in.nextLine();
		sb.append(password);
		if(query(fileL,sb.toString())==true)
			return true;
		return false;
	}
}