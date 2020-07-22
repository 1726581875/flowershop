package com.lnsf.dao;

import java.util.ArrayList;
import com.lnsf.model.User;

public interface Iuserdao {
     
      abstract User selectByName(String username);//根据用户名查单个信息
     // abstract boolean selectByName(String username);//根据用户名查单个信息判断是否存在
      abstract ArrayList<User> selectAllUser();//查全部信息
      abstract String login(String username,String password);//用户登录判断
	  abstract int register(User u);//注册用户
	  abstract boolean updateById(User u);//更新用户信息
	  boolean deleteUser(int id);
}
