package 实验三;
//声明一个像素Pixel继承Point类
public class Pixel extends Point {

	private Color color;
	public Pixel(int x,int y,Color value)
	{
		super(x,y);
		this.color=value;
	}
	public Pixel()
	{
		super();
		this.color=new Color();
	}
	public Pixel(Pixel p)
	{
	    super(p.x,p.y);
		this.color=p.color;
	}
	public int getColor()
	{
		return this.color.getRgb();
	}
	public boolean Equal(Pixel a)
	{
		return this==a||a!=null&&this.x==a.x&&this.y==a.y&&this.color.equals(a.color);
	}
	public String toString()
	{
		 return "Pixel：Point("+this.x+","+this.y+")上"+this.color;
	}
	
	
	
	public static void main(String[] args) 
	{
		Color c=new Color(256);
		Color c2=new Color(256);
		Pixel a=new Pixel(2,3,c);
		Pixel b=new Pixel(2,3,c2);
		System.out.println(a.toString());
		System.out.println(a.Equal(b));
	}
}
