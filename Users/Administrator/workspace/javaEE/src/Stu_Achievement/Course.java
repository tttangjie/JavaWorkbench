package Stu_Achievement;

public class Course {

	private String cname;
	private String cnum;
	private String teacher;
	public Course()
	{
		
	}
	public Course(String cname,String cnum,String teacher){
		this.cname=cname;
		this.cnum=cnum;
		this.teacher=teacher;
	}
	public String toString()
	{
		return cname+" "+cnum+" "+teacher;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCnum() {
		return cnum;
	}
	public void setCnum(String cnum) {
		this.cnum = cnum;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
}
