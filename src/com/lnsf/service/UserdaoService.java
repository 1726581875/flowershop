package com.lnsf.service;

import java.util.ArrayList;

import com.lnsf.model.User;

public interface UserdaoService {
    
	 int register(User u);//注册用户
     boolean updateById(User u);//更新用户信息
	 ArrayList<User> selectById(int id);//根据id查找用户
	 int login(String username,String password);//用户登录判断
	 User selectByName(String username);//根据用户名查单个信息
	 ArrayList<User> selectAllUser();
		boolean deleteUser(int id);
		boolean updateUserById(User u);//更新用户信息
}
