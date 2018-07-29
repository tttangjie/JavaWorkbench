package com.yonghu.DBdemol;

import java.util.List;

import com.yonghu.user.User;

public interface DBdemol
{
	public void add(User user);	//增
	public void delete(int id);//删
	public void update(User user);//改
	public User findbyname(String username);//查询通过username
	public List<User> findbyall();//查询所有
	public User findbynameandpwd(String username,String password);
}
