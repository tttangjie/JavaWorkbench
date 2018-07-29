package 实验四;

public abstract class ClosedFigure extends Figure{
	protected String shape;
	protected ClosedFigure(Point point,String shape)
	{
		super(point);
		this.shape=shape;
	}
	protected ClosedFigure()
	{
		this(new Point(),"未知");
	}
	public abstract double perimeter();
	public abstract double area();
	public void print()
	{
		System.out.println(this.toString()+",周长"+String.format("%1.2f,面积%1.2f", this.perimeter(),this.area()));
	}
}
