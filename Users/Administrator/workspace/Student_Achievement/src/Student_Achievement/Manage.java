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
	static int count=0;//count Ϊѧ������
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
	
	//���ļ��е�ѧ����Ϣ����ѧ�������������
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
	
	//��ѧ��������ƽ�����ɸߵ��ͽ�������д���ļ�
	public void sort(File file,Student stu[])
	{
		Student temp=null;
		for(int i=count-1;i>=0;i--)//ð������
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
	
	//�����µ�ѧ���������ѧ����Ϣ��
	public void input(File file,Student stu[])
	{
		@SuppressWarnings("resource")
		Scanner in=new Scanner(System.in);
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
			count++;
		}
		catch(IOException e){
			e.printStackTrace();
		}
		System.out.println("��Ϣ��ӳɹ���");
		System.out.println(stu[count-1].toString());
		sort(file,stu);
	}
	
	//����ѧ��ѧ�Ż����� ɾ��ѧ����Ϣ�����ɾ����ѧ����Ϣ���ַ���
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
					System.out.println("�ѳɹ�ɾ����");
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
	
	//����ѧ��������ѧ�ţ����ѧ����Ϣ
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
	
	//�г�ѧ���嵥
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
	
	//�޸�ѧ����Ϣ������ѧ����Ϣ�Զ�λ��Ҫ�޸���Ϣ��ѧ��
	//����Ļ����ʾ�޸ĺ��ѧ����Ϣ
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
					System.out.println("�������޸ĺ������");
					stu[i]=new Student();
					System.out.print("����ѧ��������");
					stu[i].setName(in.nextLine());
					System.out.print("����ѧ��ѧ�ţ�");
					stu[i].setNumber(in.nextLine());
					System.out.print("����ѧ��Ժϵ��");
					stu[i].setDepartment(in.nextLine());
					System.out.print("����ѧ��רҵ��");
					stu[i].setSpeciality(in.nextLine());
					System.out.print("����ѧ�������ɼ���");
					stu[i].setMath(in.nextInt());
					System.out.print("����ѧ��Ӣ��ɼ���");
					stu[i].setEnglish(in.nextInt());
					System.out.print("����ѧ�������ɼ���");
					stu[i].setPE(in.nextInt());
					System.out.print("����ѧ��רҵ1�ɼ���");
					stu[i].setMajor_1(in.nextInt());
					System.out.print("����ѧ��רҵ2�ɼ���");
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
	
	//����Ա�˺������ѯ
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
	
	//��ѧ���ʸ�����
	public void scholarship(File file,Student stu[],int num)
	{
		for(int i=0;i<num&&i<count;i++)
		{
			System.out.println(stu[i].getDepartment()+"\t"+stu[i].getName()+"\t"+stu[i].getNumber());
		}
	}
	
	//����Աͨ�������¼
	//����Ա�û���,����洢��login.txt��
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
		System.out.print("�û�����");
		username=in.nextLine();
		sb.append(username).append(" ");
		System.out.print("����:");
		password=in.nextLine();
		sb.append(password);
		if(query(fileL,sb.toString())==true)
			return true;
		return false;
	}
}