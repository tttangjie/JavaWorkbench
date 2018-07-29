package zuoye;
import java.util.Scanner;

public class huiwen {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		String s=input.nextLine();
		int m=(s.length()-1)/2,i;
		for(i=0;i<=m;i++)
			if(s.charAt(i)!=s.charAt(s.length()-1-i)) break;
		if(i==m+1) System.out.println(s+"是回文字符串");
		else System.out.println(s+"不是回文字符串");
		input.close();
	}

}