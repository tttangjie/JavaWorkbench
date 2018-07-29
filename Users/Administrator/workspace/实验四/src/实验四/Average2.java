package 实验四;
//去掉一个最高分和一个最低分后求平均值
public class Average2 implements Average {
	public double[] a;
	public Average2()
	{
		a=null;
	}
	public Average2(double[] a)
	{
		this.a=a;
	}
	public double avergae()
	{
		return average(a);
	}
	public double average(double[] a)
	{
		if(a==null) return 0;
		else
		{
			int max=0,min=0;
			double sum=0;
			for(int i=0;i<a.length;i++)
			{
				if(a[i]>a[max])max=i;
				if(a[i]<a[min])min=i;
			}
			if(max==min) return 0;
			else if(a.length>2)
				{
				for(int i=0;i<a.length;i++)
					if(i!=max&&i!=min) sum+=a[i];
				return sum/(a.length-2);
			    }
			else 
				return 0;	
		}
	}
}
