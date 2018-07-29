package com.yonghu.gongnenginter;

import java.util.List;

import com.yonghu.DBdemol.DBdemol;
import com.yonghu.DBdemolinter.DBdemolinter;
import com.yonghu.gongneng.Service;
import com.yonghu.user.User;

public class Serviceinter implements Service
{
	private DBdemol DB;
	public Serviceinter()
	{
		DBdemol DB=new DBdemolinter();
		this.DB=DB;
	}

	@Override
	public void addUser(User user)
	{
		// TODO Auto-generated method stub
		DB.add(user);
	}

	@Override
	public void deleteUser(int id)
	{
		// TODO Auto-generated method stub
		DB.delete(id);
	}

	@Override
	public void updateUser(User user)
	{
		// TODO Auto-generated method stub
        DB.update(user);
	}

	public User findbyname(String username)
	{
		// TODO Auto-generated method stub
		return DB.findbyname(username);
	}

	@Override
	public List<User> findbyall()
	{
		// TODO Auto-generated method stub
		return DB.findbyall();
	}
	@Override
	public User nameAndPwd(String username,String password) {
		return DB.findbynameandpwd(username, password);
	}


}
