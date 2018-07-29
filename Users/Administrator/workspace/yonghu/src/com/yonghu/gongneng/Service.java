package com.yonghu.gongneng;

import java.util.List;

import com.yonghu.user.User;

public interface Service
{
	public void addUser(User user);//注册
	public void deleteUser(int id);//删除
	public void updateUser(User user);//更新
	public User findbyname(String username);//根据username寻找
    public List<User> findbyall();//查找全部
	public User nameAndPwd(String username, String password);
}
