package 实验四;

public class Main {
	public static void main(String[] args)
	{
		double [] s={2,5,9,13};
		int [] x={1,10,11,15};
		Average1 a=new Average1(s);
		Average2 b=new Average2(s);
		Average3 c=new Average3(s,x);
	    System.out.println(a.avergae());
		System.out.println(b.avergae());
		System.out.println(c.avergae());
		Cone co=new Cone(new Circle(new Point(0,0),5),5);
		System.out.println(co+"\n表面积："+co.area()+"\n体积："+co.volume());
	}
}
