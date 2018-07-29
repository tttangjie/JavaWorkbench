package Student_Achievement;

public class Student {
	private int Math,English,PE,Major_1,Major_2,sum;
	private double average;
	private String name,department,speciality,number;//系，专业，学号
	public Student()//构造方法
	{
	}
	public Student(String name,String number,String department,String speciality,int Math,int English,int PE,int Major_1,int Major_2)//构造方法
	{
		this.set(name,number,department,speciality,Math,English,PE,Major_1,Major_2);
	}
	public void set(String name,String number,String department,String speciality,int Math,int English,int PE,int Major_1,int Major_2)
	{
		this.name=name;
		this.number=number;
		this.department=department;
		this.speciality=speciality;
		this.Math=Math;
		this.English=English;
		this.PE=PE;
		this.Major_1=Major_1;
		this.Major_2=Major_2;
	}
	public Student(Student st)
	{
		this.set(st.name, st.number, st.department, st.speciality, st.Math, st.English, st.PE, st.Major_1, st.Major_2);
	}
	/*public void finalize()//析构方法
	{
		this.finalize();
		Student.count--;
	}*/
	public int sum()//计算总分
	{
		return this.sum=this.Math+this.English+this.PE+this.Major_1+this.Major_2;
	}
	public double average()//计算平均分
	{
		return this.average=sum()/5.0;
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	public void setNumber(String number)
	{
		this.number=number;
	}
	public void setDepartment(String department)
	{
		this.department=department;
	}
	public void setSpeciality(String speciality)
	{
		this.speciality=speciality;
	}
	public void setMath(int Math)
	{
		this.Math=Math;
	}
	public void setEnglish(int English)
	{
		this.English=English;
	}
	public void setPE(int PE)
	{
		this.PE=PE;
	}
	public void setMajor_1(int Major_1)
	{
		this.Major_1=Major_1;
	}
	public void setMajor_2(int Major_2)
	{
		this.Major_2=Major_2;
	}
	
	public String getName()
	{
		return this.name;
	}
	public String getNumber()
	{
		return this.number;
	}
	public String getDepartment()
	{
		return this.department;
	}
	public String getSpeciality()
	{
		return this.speciality;
	}
	public int getMath()
	{
		return this.Math;
	}
	public int getEnglish()
	{
		return this.English;
	}
	public int getPE()
	{
		return this.PE;
	}
	public int getMajor_1()
	{
		return this.Major_1;
	}
	public int getMajor_2()
	{
		return this.Major_2;
	}
	public double getAverage()
	{
		return this.average;
	}
	public int getSum()
	{
		return this.sum;
	}
	
	public String toString()
	{
		return this.name+'\t'+this.number+"\t"+this.department+"\t"+this.speciality+"\t"+this.Math+"\t"+this.English+"\t"+this.PE+"\t"+this.Major_1+"\t"+this.Major_2+"\t"+sum()+"\t"+average();
	}
}
