package ʵ����;

public class Figure {
	public Point point;
	protected Figure(Point point)
	{
		this.point=point;
	}
	protected Figure()
	{
		this(new Point());
	}
}
