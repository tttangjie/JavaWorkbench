package zuoye;

import java.util.Scanner;

public class yanghui {

	public static void main(String[] args) {
		int n,i,j;
		Scanner input=new Scanner(System.in);
		n=input.nextInt();
        int[] a=new int[n];
		a[0]=1;
		for(j=0;j<n;j++)
		{
			a[j]=1;
			for(i=j-1;i>0;i--)
				a[i]=a[i]+a[i-1];
			for(i=0;i<n-1-j;i++)
				System.out.print("   ");
			for(i=0;i<=j;i++)
				System.out.printf("%6d",a[i]);
			System.out.println();
			input.close();
		}
	}

}
