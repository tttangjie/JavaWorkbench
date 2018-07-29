package ʵ����;
public class Cone implements Area, Volume {
	protected Circle circle;
	protected double height;
	public Cone()
	{
		this.circle=new Circle(new Point(0,0),0);
		this.height=0;
	}
	public Cone(Circle circle,double height)
	{
		this.circle=circle;
		this.height=height;
	}
	public double volume() {
		return (1.0/3)*Math.PI*circle.radius*circle.radius*height;
	}

	public double area() {
		return Math.PI*circle.radius*Math.sqrt(circle.radius*circle.radius+height*height)+circle.area();
	}
	public String toString()
	{
		return "Cone ����Ϊ�뾶Ϊ��"+this.circle.radius+"��Բ  ��Ϊ��"+this.height;
	}
}
