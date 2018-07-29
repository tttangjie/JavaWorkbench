package Stu_Achievement;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SearchStu {
	public SearchStu(){
		
	}
	public SearchStu(File file,String info)//���Һ���ĳ��Ϣ��ѧ������
	{
		BufferedReader br=null;
		try{
			FileReader fr=new FileReader(file);
			br=new BufferedReader(fr);
			String contain=br.readLine();
			while(contain!=null){
				if(contain.contains(info)){
					System.out.println(contain);
					contain=br.readLine();
				}
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
	}
	public SearchStu(File file)//ѧ���ɼ��嵥
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
}
