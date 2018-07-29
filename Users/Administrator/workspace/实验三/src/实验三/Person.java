package 实验三;
//声明一个Person类
public class Person {
	public String name;
	public MyDate birthday;
	public String sex,province,city;
	private static int count=0;
	public Person(String name,MyDate birthday,String sex,String province,String city)
	{
		this.set(name,birthday,sex,province,city);	
		count ++;
	}
	public Person(String name,MyDate birthday)
	{
		this(name,birthday,"","","");
	}
	public Person()
	{
		this("",null);
	}
	public Person(Person p)
	{
		this(p.name,new MyDate(p.birthday),p.sex,p.province,p.city);
	}
	public void finalize()
	{
		System.out.println("释放对象("+this.toString()+")");
		Person.count--;
	}
	public static void howMany()
	{
		System.out.print(Person.count+"个Person对象");
	}
	public void set(String name,MyDate birthday,String sex,String province,String city)
	{
		this.name=name==null?"":name;
		this.birthday=birthday;
		this.sex=sex==null?"":sex;
		this.province=province==null?"":province;
		this.city=city==null?"":city;
	}
	public String toString()
	{
		return name+","+(birthday==null?"":birthday.toString())+","+sex+","+","+province+","+city;
	}
}