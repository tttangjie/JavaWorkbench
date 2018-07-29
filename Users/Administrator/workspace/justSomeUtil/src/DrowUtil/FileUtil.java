package DrowUtil;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FileUtil {
	public FileUtil()
	{
		
	}
	public static ArrayList<String> readTxtFile(String filePath)
	{
		File file = new File(filePath);
		 ArrayList<String>   studentName = new ArrayList<String>();
		int pos=0;
		if(file.isFile()&&file.exists())
		{
			try {
				Scanner scanner = new Scanner(new FileInputStream(filePath));
				int i=0;
				while(scanner.hasNext())
				{
					studentName.add(scanner.next());
					
					i++;
				//	System.out.println(i);
				}
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		return studentName;
	}
/*	@SuppressWarnings("null")
	public static void main(String args[])
	{
		//readTxtFile("C:\\1.txt");
		ArrayList<String>  al = new  ArrayList<String>() ;
		al.add("1");
		al.add("2");
		al.add("3");
		al.add("4");
		for(int i=0;i<4;i++)
		{
			System.out.println(al.get(0));
			al.remove(0);
		}
	}*/

}
