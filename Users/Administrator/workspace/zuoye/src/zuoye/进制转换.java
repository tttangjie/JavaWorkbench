package zuoye;

import java.util.Scanner;

public class 进制转换 {
	public static int parseInt(String s,int radix)throws NumberFormatException
	{
		int n=0,i=0,sign=1;
		char c=s.charAt(i);
		//if(s==null)
			//throw new NumberFormatException("NULL");
		if(radix==10)
			{
			if(c=='+'||c=='-')i++;
			sign=c=='-'?-1:1;
			}
		if(c=='0'&&radix==8)i++;
		else if(radix==16&&c=='0'&&s.charAt(1)=='x')i=i+2;
		else if(radix==2||radix==4);
		else throw new NumberFormatException("整数不能识别"+c+"字符");
		while(i<s.length())
		{
			c=s.charAt(i++);
			if(c>='0'&&c-'0'<radix)
				n=n*radix+c-'0';
			else if(radix==16&&c>='A'&&c<='F')
				n=n*radix+c-'A'+10;
			else if(radix==16&&c>='a'&&c<='f')
				n=n*radix+c-'a'+10;
			else throw new NumberFormatException(radix+"进制整数不能识别"+c+"字符");
		}		
		return n*sign;
	}

	

	public static void main(String[] args) {
		Scanner input =new Scanner(System.in);
		System.out.print("Please input a string:");
		String s=input.nextLine();
		System.out.print("please input radix:");
		int radix=input.nextInt();
		int n;
		n=parseInt(s,radix);
		System.out.print(radix+"进制字符串转化为整数"+n);
		input.close();
	}

}
