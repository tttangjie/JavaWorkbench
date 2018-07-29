package 实验四;
//求平均值
public class Average1 implements Average {
	public double[] a;
	public Average1()
	{
		a=null;
	}
	public Average1(double a[])
	{
		this.a=a;
	}
	public double avergae()
	{
		return average(a);
	}
	public double average(double[] a)
	{
		if(a==null)
			return 0;
		else
		{
			double sum=0;
		    for(int i=0;i<a.length;i++)
		    	sum+=a[i];
		    return sum/a.length;
		}
	}
}
