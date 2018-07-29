package 实验三;
//Student继承Person类，增加功能学号以各专业分类自动编号;增加多门成绩变量
public class Student extends Person {
	public int Math,English,Computer,PE,History;
	//增加 高等数学，大学英语，计算机基础，大学体育，近现代史 成绩变量
	private static int count1=0,count2=0,count3=0,count4=0,count5=0,count6=0;
	public String department,speciality,number;
	public boolean member;
	private static int count=0;
	public Student(String name,MyDate birthday,String sex,String province,String city,String department,String speciality,String number,boolean member,int Math,int English,int Computer,int PE,int History)
	{
		super(name,birthday,sex,province,city);
		this.set(department,speciality,number,member,Math,English,Computer,PE,History);
		count++;
	}
	public Student()
	{
		this("",new MyDate(),"","","","","","",false,0,0,0,0,0);
	}
	public Student(Person p,String department,String speciality,String number,boolean member,int Math,int English,int Computer,int PE,int History)
	{
		this(p.name,new MyDate(p.birthday),p.sex,p.province,p.city,department,speciality,number,member,Math,English,Computer,PE,History);
	}
	public Student(Student s)
	{
		this(s.name,new MyDate(s.birthday),s.sex,s.province,s.city,s.department,s.speciality,s.number,s.member,s.Math,s.English,s.Computer,s.PE,s.History);
	}
	protected int sum()
	{
		return this.Math+this.English+this.Computer+this.PE+this.History;
	}
	protected double average()
	{
		return sum()/5;
	}
	public void finalize()
	{
		super.finalize();
		Student.count--;
	}
	public static void howMany()
	{
		Person.howMany();
		System.out.println(Student.count+"个Student对象");
	}
	public String setNumber()//学号以专业自动分类
	{
		number+="16";
		switch(department)
		{
		case "软件工程学院":number+="01";
		     switch(speciality)
		     {
		     case "软件工程":number+="01";break;
		     case "软件工程嵌入式":number+="02";break;
		     case "软件工程NIIT":number+="03";break;
		     default:this.number+="00";
		     }
		     if(++count1<10)
		    	 number+="0";
		    	 number+=String.format("%d", count1);
		     break;
		case "商学院":number+="02";
		     switch(speciality)
		     {
		     case "金融":number+="01";break;
		     case "会计":number+="02";break;
		     case "财务管理":number+="03";break;
		     default:number+="00";
		     }
		     if(++count2<10)
		    	 number+="0";
		     number+=String.format("%d", count2);
		     break;
		case "人文学院":number+="03";
	         switch(speciality)
	         {
	         case "汉语言文学":number+="01";break;
	         case "历史学":number+="02";break;
	         case "广播新闻学":number+="03";break;
	         default:number+="00";
	         }
	         if(++count3<10)
		    	 number+="0";
	         number+=String.format("%d", count3);
	         break;
		case "动漫学院":number+="04";
	         switch(speciality)
	         {
	         case "动漫影视":number+="01";break;
	         case "动漫游戏":number+="02";break;
	         case "动漫设计":number+="03";break;
	         default:number+="00";
	         }
	         if(++count4<10)
		    	 number+="0";
	         number+=String.format("%d", count4);
	         break;
		case "艺术学院":number+="05";
	         switch(speciality)
	         {
	         case "绘画":number+="01";break;
	         case "美术学":number+="02";break;
	         case "艺术设计学":number+="03";break;
	         default:number+="00";
	         }
	         if(++count5<10)
		    	 number+="0";
	         number+=String.format("%d", count5);
	         break;
		default:number+="0000";
		if(++count6<10)
	    	 number+="0";
		number+=String.format("%d", count6);
		}
		return number;
	}
	public String getNumber()
	{
		return setNumber();
	}
	
	public void set(String department,String speciality,String number,boolean member,int Math,int English,int Computer,int PE,int History)
	{
		this.department=department==null?"":department;
		this.speciality=speciality==null?"":speciality;
		this.number=number==null?"":number;
		this.member=member;
		this.Math=Math;
		this.English=English;
		this.Computer=Computer;
		this.PE=PE;
		this.History=History;
		
	}
	public String toString()
	{
		return super.toString()+","+department+","+speciality+","+number+(member?",团员":"");
	}
	
	public static void main(String[] args) 
	{
		MyDate d1=new MyDate(1997,2,1);
		MyDate d2=new MyDate(1997,6,11);
		Student s1=new Student("李明",d1,"男","江苏","泰州","软件工程学院","软件工程","",false,80,95,85,88,92);
		Student s2=new Student("殷虹",d2,"女","江苏","泰州","软件工程学院","软件工程","",true,88,93,87,90,87);
		System.out.println("李明"+'\n'+"学号："+s1.getNumber()+'\n'+"总分："+s1.sum()+'\n'+"殷虹"+'\n'+"学号："+s2.getNumber()+'\n'+"总分："+s2.sum());
	}

}