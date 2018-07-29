package Stu_Achievement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SortStu {
	public SortStu(){
		
	}
	public SortStu(File file,Student stu[])
	{
		Student temp=null;
		for(int i=MainStu.count-1;i>=0;i--)//以平均分进行冒泡排序
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
			for(int i=0;i<MainStu.count;i++)
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
}
