package com.yonghu.DBdemol;

import java.util.List;

import com.yonghu.user.User;

public interface DBdemol
{
	public void add(User user);	//��
	public void delete(int id);//ɾ
	public void update(User user);//��
	public User findbyname(String username);//��ѯͨ��username
	public List<User> findbyall();//��ѯ����
	public User findbynameandpwd(String username,String password);
}
