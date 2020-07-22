package com.lnsf.service.impl;

import java.util.ArrayList;
import java.util.Scanner;

import com.lnsf.dao.impl.Userdaoimpl;
import com.lnsf.model.User;
import com.lnsf.service.UserdaoService;


public class UserdaoServiceimpl implements UserdaoService{

	Userdaoimpl user = new Userdaoimpl();
	
	
	
	@Override
	public User selectByName(String username) {
		
		return user.selectByName(username);
	}

	@Override
	public ArrayList<User> selectById(int id) {
		
		return null;
		
	}

	@Override
	public int register(User u) {
		
		int flag = 0;
		//判断用户名是否已存在
		String username = (user.selectByName(u.getUsername())).getUsername();
		if(username == null){//不存在，可注册
			flag = user.register(u);	
		}else{//已存在，不能注册
			System.out.println("该用户名已存在！");
		}			
		return flag;
	}

	@Override
	public boolean updateById(User u) {
		 boolean flag = false;
			if(user.selectByName(u.getUsername()).getUsername() == null) {//不存在，可改
				user.updateById(u);
				flag = true;
				
			}else{//已存在用户名，不可改
		        flag = false;
			}
		 
		return flag;
	}

	@Override
	public int login(String username, String password) {
		
		int flag = 0;
		String usertype = user.login(username, password);
		if(usertype.equals("顾客")){
			System.out.println("欢迎您登录本花店!");
			flag = 2;
		}
		else if(usertype.equals("店员")) {
			System.out.println("欢迎您，管理员！");
			flag = 1;
		}else{
			System.err.println("输入格式有误或者用户不存在");
		}
		
		return flag;
	}

	
	
	@Override
	public boolean updateUserById(User u) {
		boolean flag = false;
		Scanner input = new Scanner(System.in);
		System.out.println("请输入userid：");
		int userid = input.nextInt();
		System.out.println("请输入username：");
		String username = input.next();
		System.out.println("请输入usertype：");
		String usertype = input.next();
		System.out.println("请输入password：");
		String password = input.next();
		System.out.println("请输入address：");
		String address = input.next();
		u.setUserid(userid);
		u.setUsername(username);
		u.setUsertype(usertype);
		u.setPassword(password);
		u.setAddress(address);
        flag = user.updateById(u);
        if(flag == false)
			System.out.println("该用户不存在！"); 	
		if(flag == true)
			System.out.println("该用户修改成功！");
		return flag;
	}


	@Override
	public boolean deleteUser(int id) {
		// TODO Auto-generated method stub
		boolean flag = false;
		flag = user.deleteUser(id);
		if(flag == false)
				System.out.println("该用户不存在！"); 	
			if(flag == true)
				System.out.println("该用户删除成功！");
		return flag;
	}

	@Override
	public ArrayList<User> selectAllUser() {
		// TODO Auto-generated method stub
		
		return user.selectAllUser();
	}

	
	
}
