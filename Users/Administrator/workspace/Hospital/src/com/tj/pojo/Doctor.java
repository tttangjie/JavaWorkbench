package com.tj.pojo;

public class Doctor {
	private String dno;
	private String dname;
	private String dsex;
	private int age;
	private String dtel;
	private String depno;
	public String getDno() {
		return dno;
	}
	public void setDno(String dno) {
		this.dno = dno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getDsex() {
		return dsex;
	}
	public void setDsex(String dsex) {
		this.dsex = dsex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDtel() {
		return dtel;
	}
	public void setDtel(String dtel) {
		this.dtel = dtel;
	}
	public String getDepno() {
		return depno;
	}
	public void setDepno(String depno) {
		this.depno = depno;
	}
	@Override
	public String toString() {
		return "Doctor [dno=" + dno + ", dname=" + dname + ", dsex=" + dsex
				+ ", age=" + age + ", dtel=" + dtel + ", depno=" + depno + "]";
	}
	
}