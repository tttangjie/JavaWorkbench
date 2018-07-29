package สตั้หฤ;

public class Circle extends ClosedFigure {
	protected double radius;
	public Circle(Point p,double radius)
	{
		this.point=p;
		this.radius=radius;
	}
	public Circle()
	{
		this.point=new Point(0,0);
		this.radius=0;
	}
	public double perimeter() {
		return 2*Math.PI*radius;
	}
	public double area() {
		return Math.PI*radius*radius;
	}

}
