package com.yonghu.gongneng;

import java.util.List;

import com.yonghu.user.User;

public interface Service
{
	public void addUser(User user);//ע��
	public void deleteUser(int id);//ɾ��
	public void updateUser(User user);//����
	public User findbyname(String username);//����usernameѰ��
    public List<User> findbyall();//����ȫ��
	public User nameAndPwd(String username, String password);
}
