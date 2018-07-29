package com.users.po;

public class User {
	private String id;
	private String pwd;
	private String name;
	private int age;
	private String sex;
	public User()
	{
		
	}
	public User(String id,String pwd,String name,int age,String sex){
		this.id=id;
		this.pwd=pwd;
		this.name=name;
		this.age=age;
		this.sex=sex;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
}
