package 实验五;

public class Main {
	public static void main(String[] args)
	{
		MyDate d1=new MyDate("20年08月01日","yy年MM月dd日");
		System.out.println(d1.year+"月"+d1.month+"月"+d1.day+"日");
    	Complex c1=new Complex("5+ci");
		System.out.println(c1.real+"    "+c1.image+"i");
	}
}
