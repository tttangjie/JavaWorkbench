package zuoye;

import java.util.Scanner;

public class Sushu {

	public static void main(String[] args) {
		int n,i,j;
		Scanner input=new Scanner(System.in);
		n=input.nextInt();
		for(i=2;i<=n;i++)
		{
		  for(j=2;j<i;j++)
		    if(i%j==0) break;
		  if(i==j)
		  System.out.print(i+" ");
		}
		input.close();

	}

}
