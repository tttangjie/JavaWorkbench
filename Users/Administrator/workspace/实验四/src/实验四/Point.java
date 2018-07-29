package 实验四;
//声明一个坐标Point类
public class Point {

    int x,y;
	public Point(int x,int y)
	{
		this.set(x,y);
	}
	public Point() //指定默认坐标点（0,0）
	{
		this.set(0,0);
	}
	public Point(Point a)
	{
		this.set(a);
	}
	public void set(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	public void set(Point a)
	{
		this.set(a.x,a.y);
	}
	public int getX()
	{
		return this.x;
	}
	public int getY()
	{
		return this.y;
	}
	public boolean Equal(Point a)
	{
		return this==a||a!=null&&this.x==a.x&&this.y==a.y;
	}
	public String toString()
	{
		return "Point("+String.format("%d",x)+","+String.format("%d", y)+")";
	}
}
    