package 实验三;
//比较两个数组是否相等
public class Equals {
	public static boolean equals(int a[],int b[])
	{
		int flag=1;
		if(a.length!=b.length)
			return false;
		for(int i=0;i<a.length;i++)
		{
			if(a[i]!=b[i])
				{
				flag=0;
				break;
				}
		}
		return flag==1;
	}
	public static boolean equals(Object a[],Object b[])
	{
		if(a==b) return true;
		if(a!=null&&b!=null&&a.length==b.length)
		{
			for(int i=0;i<a.length;i++)
			{
				if(a[i]==b[i]) continue;
				if(a[i]!=null&&a[i].equals(b[i]))continue;
				else if(a[i]==null) return false;
			}
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Object a[]={0,1,2,3},b[]={0,1,2,3};
		boolean t=equals(a,b);
		System.out.println("a[]equalsb[]?  "+t);
	}
}
