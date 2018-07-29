package zuoye;

import java.util.Scanner;

public class Josephus {
	public static int Jose(int n,int s,int d)
	{
		int[] a=new int[n];
		int j,i,t;
		for(i=0;i<n;i++)
			a[i]=1;
		j=(s-2+d)%n;
		a[j]=0;
		System.out.println("Number "+(j+1)+" 出环");
		for(i=1;i<n-1;i++)
		{
			t=d;
			while(t!=0)
			{
				j=(j+1)%n;
				if(a[j]==1) t--;
			}
			a[j]=0;
			System.out.println("Number "+(j+1)+" 出环");
		}
		i=0;
		while(a[i]==0)
			i++;
		return i+1;
	}

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("Please input n,s,d:");
		int n=input.nextInt(),s=input.nextInt(),d=input.nextInt(),Lucky;
		Lucky=Jose(n,s,d);
		System.out.println("The lucky one is Number:"+Lucky);
		input.close();
	}

}
