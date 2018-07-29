package 实验四;
//求加权平均值
public class Average3 implements Average {
	public double[] a;
	public int[] x;
	public Average3()
	{
		a=null;
		x=null;
	}
	public Average3(double a[],int[] x)
	{
		this.a=a;
		this.x=x;
	}
	public double avergae()
	{
		return average(a,x);
	}
	public double average(double[] a,int[] x)
	{
		if(a==null||x==null)
			return 0;
		else
		{
			double sum=0,weights=0;
			for(int i=0;i<a.length&&i<x.length;i++)
			{
				sum+=a[i]*x[i];
				weights+=x[i];
			}
			return sum/weights;
		}
	}
}
