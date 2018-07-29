package DrowUtil;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
public class Drow {
	public static ArrayList<String> studentName=null;
	public static ArrayList<String> projectName=null;
	public Drow(String namePath,String projectPath)
	{
	  studentName = FileUtil.readTxtFile(namePath); // 源数据
	  projectName = FileUtil.readTxtFile(projectPath);// 源数据
	}
	public String[] toRandom(String[]  name)
	{
		
		int countName = name.length;
		int randomPosition;
		int time=(int) (Math.random()*100+20);
		//System.out.println(time);
		for(int j=0;j<time;j++)
		{    
			for(int i=0;i<countName;i++ )
			{
				do
				{
					randomPosition = (int) (countName*Math.random());
				}while(randomPosition>=countName);
				String temp = name[randomPosition];
			    name[randomPosition] = name[i];
			    name[i] = temp;
			}
		}
		return name;
	}
	public void  toCombine() throws IOException
	{
		String[] name = this.toRandom(studentName.toArray(new String[studentName.size()]));
		String[] project = projectName.toArray(new String[projectName.size()]);
		int numberNum = studentName.size()/projectName.size();
		//Scanner sc = new Scanner("E:\\大三上\\studentNameDivid.txt");
		//FileWriter fw = new FileWriter("E:\\大三上\\studentNameDivid.txt"); 
		
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		// new Date()为获取当前系统时间
		String time = df1.format(new Date());
		time=time.replaceAll(" ", "_");
		time=time.replaceAll(":", "_");
		System.out.println(time);
		String filename=time+".txt";
		
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("E:\\大三上\\"+filename)),true);  
		
		for(int i=0;i<studentName.size();i++)
		{
			if(i%numberNum==0)
			{
				System.out.println('\n'+project[i/numberNum]+"  ");
			//	pw.println('\n'+project[i/numberNum]+"  ");
			}
			System.out.print(name[i] + "  ");
			pw.println(name[i]);
		}
		
	}
	public static void main(String args[]) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		String path1,path2;
		//path1 = sc.nextLine();
		///path2 = sc.nextLine();
		path1 ="E:\\大三上\\studentName.txt";
		path2 = "E:\\大三上\\projectName.txt";
		Drow dr = new Drow(path1,path2);
		dr.toCombine();
		
		
	}

}
