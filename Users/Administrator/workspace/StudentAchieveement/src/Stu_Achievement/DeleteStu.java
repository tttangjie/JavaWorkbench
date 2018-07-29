package Stu_Achievement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DeleteStu {
	public DeleteStu(){
		
	}
	public DeleteStu(File file,String info,Student stu[])throws Exception
	{
		
		try {
			FileReader fr=new FileReader( file);
			BufferedReader br=new BufferedReader(fr);
			StringBuffer sb=new StringBuffer(4096);
			String contain=null;
			while((contain=br.readLine())!=null)
			{
				if(contain.contains(info))
				{
					System.out.println(contain);
					continue;
				}
				sb.append(contain).append("\r\n");	
			}
			new ArrayStu(file,stu);
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
}
