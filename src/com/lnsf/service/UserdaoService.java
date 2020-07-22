package com.lnsf.service;

import java.util.ArrayList;

import com.lnsf.model.User;

public interface UserdaoService {
    
	 int register(User u);//ע���û�
     boolean updateById(User u);//�����û���Ϣ
	 ArrayList<User> selectById(int id);//����id�����û�
	 int login(String username,String password);//�û���¼�ж�
	 User selectByName(String username);//�����û����鵥����Ϣ
	 ArrayList<User> selectAllUser();
		boolean deleteUser(int id);
		boolean updateUserById(User u);//�����û���Ϣ
}
