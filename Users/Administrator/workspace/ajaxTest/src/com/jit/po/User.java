package com.jit.po;

public class User {
	String userName;
	String  pwd;
	public User() {}
	
	public User(String a,String b)
	{
		userName=a;
		pwd=b;
	}
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
