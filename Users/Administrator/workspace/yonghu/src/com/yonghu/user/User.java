package com.yonghu.user;

public class User
{
   private String username;//�û���
   private String password;//����
   private int age;//����
   private String sex;//�Ա�
   private String info;//�û���Ϣ
   private int power;//power=0Ϊ��ͨ�û���Ϊ1���ǹ���Ա
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