package ʵ����;
//����Complex��ʵ��Comparable�ӿ�
public class Complex implements Comparable<Complex> {
 	private double real,image;
	public int compareTo(Complex a)
	{
		if(Math.sqrt(this.real*this.real+this.image*this.image)>Math.sqrt(a.real*a.real+a.image*a.image))
			return 1;
		else if(Math.sqrt(this.real*this.real+this.image*this.image)==Math.sqrt(a.real*a.real+a.image*a.image))
			return -1;
		else return 0;
	};
}
