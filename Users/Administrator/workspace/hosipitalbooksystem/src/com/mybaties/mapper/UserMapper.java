package com.mybaties.mapper;

import com.po.*;

public interface UserMapper {
	public  User findUserById(String id);
	public  void  insertUserInfo(User user);
	public  void deleteUserById(String id);
	public void updateUserById(User user);
}
