package ʵ����;
//Student�̳�Person�࣬���ӹ���ѧ���Ը�רҵ�����Զ����;���Ӷ��ųɼ�����
public class Student extends Person {
	public int Math,English,Computer,PE,History;
	//���� �ߵ���ѧ����ѧӢ��������������ѧ���������ִ�ʷ �ɼ�����
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
		System.out.println(Student.count+"��Student����");
	}
	public String setNumber()//ѧ����רҵ�Զ�����
	{
		number+="16";
		switch(department)
		{
		case "�������ѧԺ":number+="01";
		     switch(speciality)
		     {
		     case "�������":number+="01";break;
		     case "�������Ƕ��ʽ":number+="02";break;
		     case "�������NIIT":number+="03";break;
		     default:this.number+="00";
		     }
		     if(++count1<10)
		    	 number+="0";
		    	 number+=String.format("%d", count1);
		     break;
		case "��ѧԺ":number+="02";
		     switch(speciality)
		     {
		     case "����":number+="01";break;
		     case "���":number+="02";break;
		     case "�������":number+="03";break;
		     default:number+="00";
		     }
		     if(++count2<10)
		    	 number+="0";
		     number+=String.format("%d", count2);
		     break;
		case "����ѧԺ":number+="03";
	         switch(speciality)
	         {
	         case "��������ѧ":number+="01";break;
	         case "��ʷѧ":number+="02";break;
	         case "�㲥����ѧ":number+="03";break;
	         default:number+="00";
	         }
	         if(++count3<10)
		    	 number+="0";
	         number+=String.format("%d", count3);
	         break;
		case "����ѧԺ":number+="04";
	         switch(speciality)
	         {
	         case "����Ӱ��":number+="01";break;
	         case "������Ϸ":number+="02";break;
	         case "�������":number+="03";break;
	         default:number+="00";
	         }
	         if(++count4<10)
		    	 number+="0";
	         number+=String.format("%d", count4);
	         break;
		case "����ѧԺ":number+="05";
	         switch(speciality)
	         {
	         case "�滭":number+="01";break;
	         case "����ѧ":number+="02";break;
	         case "�������ѧ":number+="03";break;
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
		return super.toString()+","+department+","+speciality+","+number+(member?",��Ա":"");
	}
	
	public static void main(String[] args) 
	{
		MyDate d1=new MyDate(1997,2,1);
		MyDate d2=new MyDate(1997,6,11);
		Student s1=new Student("����",d1,"��","����","̩��","�������ѧԺ","�������","",false,80,95,85,88,92);
		Student s2=new Student("���",d2,"Ů","����","̩��","�������ѧԺ","�������","",true,88,93,87,90,87);
		System.out.println("����"+'\n'+"ѧ�ţ�"+s1.getNumber()+'\n'+"�ܷ֣�"+s1.sum()+'\n'+"���"+'\n'+"ѧ�ţ�"+s2.getNumber()+'\n'+"�ܷ֣�"+s2.sum());
	}

}