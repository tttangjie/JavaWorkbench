package 实验三;
//声明颜色Color类
public class Color
 {
	int value;
	private final int a=0xff;
	public Color()
	{
		this.set(0, 0, 0);
	}
	public Color(int red,int green,int blue)
	{
		this.set(red,green,blue);
	}
	public void set(int red,int green,int blue)
	{
		this.value=0xff000000|(red<<16&0xff0000)|(green<<8&0xff00)|(blue&0xff);
	}
	public int setRed(int red)
	{
		return (red&0xff)<<16;
	}
	public int setGreen(int green)
	{
		return (green&0xff)<<8;
	}
	public int setBlue(int blue)
	{
		return blue&0xff;
	}
	public Color(int i)
	{
		value=0xff000000|i;
	}
	public int getRgb()
	{
		return value;
	}
	public int getRed()
	{
		return  getRgb()>>16&a;
	}
	public int getGreen()
	{
		return getRgb()>>8&a;
	}
	public int getBlue()
	{
		return getRgb()&a;
	}
	public String toString()
	{
		return "RGB值为("+String.format("%d", getRed())+","+String.format("%d", getGreen())+","+String.format("%d", getBlue())+")";
	}
	public static void main(String[] args)
	{
		Color a = new Color(0xff00ff00);
		System.out.println(a);
	}
}