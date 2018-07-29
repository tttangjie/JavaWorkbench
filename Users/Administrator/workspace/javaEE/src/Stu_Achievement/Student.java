
package Stu_Achievement;

import java.util.LinkedList;

public class Student {
	private String num;
	private String name;
	private String age;
	private String sex;
	private LinkedList<Course> cs = new LinkedList();
	public Student()
	{
		
	}
	public Student(String num,String name,String age,String sex,LinkedList<Course> cs){
		this.num=num;
		this.name=name;
		this.age=age;
		this.sex=sex;
		this.cs=cs;
	}
	public String toString(){
		String result=num+" "+name+" "+age+" "+sex;
		for(int i=0;i<cs.size();i++){
			result+=" "+cs.get(i).getCname();
		}
		return result;
		
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public LinkedList<Course> getCs() {
		return cs;
	}
	public void setCs(LinkedList<Course> cs) {
		this.cs = cs;
	}


}
