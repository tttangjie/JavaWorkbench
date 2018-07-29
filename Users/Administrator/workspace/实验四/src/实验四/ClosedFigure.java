package ʵ����;

public abstract class ClosedFigure extends Figure{
	protected String shape;
	protected ClosedFigure(Point point,String shape)
	{
		super(point);
		this.shape=shape;
	}
	protected ClosedFigure()
	{
		this(new Point(),"δ֪");
	}
	public abstract double perimeter();
	public abstract double area();
	public void print()
	{
		System.out.println(this.toString()+",�ܳ�"+String.format("%1.2f,���%1.2f", this.perimeter(),this.area()));
	}
}
