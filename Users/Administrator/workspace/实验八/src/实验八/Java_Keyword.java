package 实验八;
//将Java关键字保存在文本文件中，判断一个字符串是否为Java的关键字
import java.io.*;
import java.util.Scanner;
public class Java_Keyword {
	private boolean isJavaKeyword(String word) throws IOException{
		String filename="Java_Keyword.txt";
		FileReader fr=new FileReader(filename);
		BufferedReader br=new BufferedReader(fr);
		String javakeyword=null;
		while((javakeyword=br.readLine())!=null)
		{
			if(javakeyword.equals(word))
			{
				br.close();
				return true;
			}
		}
		br.close();
		return false;
	}

	public static void main (String[] args) throws IOException{
		Scanner input=new Scanner(System.in);
		String word=null;
		boolean isjavakeyword=false;
		System.out.println("Please input a string");
		word=input.nextLine();
		isjavakeyword=new Java_Keyword().isJavaKeyword(word);
		System.out.println(word+" is java keyword? "+isjavakeyword);
	}
}
