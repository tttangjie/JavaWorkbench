package com.yonghu.user;

public class User
{
   private String username;//用户名
   private String password;//密码
   private int age;//年龄
   private String sex;//性别
   private String info;//用户信息
   private int power;//power=0为普通用户，为1则是管理员
   public User(){}
   public User(String username,String password,int age,String sex,String info,int power)
   {
	   this.username=username;
	   this.password=password;
	   this.age=age;
	   this.sex=sex;
	   this.info=info;
	   this.power=power;
   }

public String getUserName()
{
	return username;
}
public void setUserName(String username)
{
	this.username = username;
}
public String getPassword()
{
	return password;
}
public void setPassword(String password)
{
	this.password = password;
}
public int getAge()
{
	return age;
}
public void setAge(int age)
{
	this.age = age;
}
public String getSex()
{
	return sex;
}
public void setSex(String sex)
{
	this.sex = sex;
}
public String getInfo()
{
	return info;
}
public void setInfo(String info)
{
	this.info = info;
}
public int getPower()
{
	return power;
}
public void setPower(int power)
{
	this.power = power;
}
   
}