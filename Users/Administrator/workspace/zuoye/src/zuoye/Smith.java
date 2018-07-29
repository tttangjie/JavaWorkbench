package zuoye;

public class Smith {
	public static int isprime(int n)
	{
		int i;
		for(i=2;i<n;i++)
			if(n%i==0) break;
		if(i==n) return 1;
		return 0;
	}
	public static int sum(int m)
	{
		int s=0;
		while(m!=0)
		{
			s=s+m%10;
			m=m/10;
		}
		return s;
	}

	public static void main(String[] args) {

		int m,i,s,t,n;
		for(m=2;m<400;m++)
		{
			s=t=0;
			n=m;
			s=sum(m);
			for(i=2;i<m;i++)
			{
				if(n%i==0&&isprime(i)==1)
				{
				    	t=t+sum(i);
					    n=n/i;
					    i--;
				}
			}
			if(t==s) System.out.print(m+" ");	
		}
	}
}


