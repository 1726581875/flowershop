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
		//�ж��û����Ƿ��Ѵ���
		String username = (user.selectByName(u.getUsername())).getUsername();
		if(username == null){//�����ڣ���ע��
			flag = user.register(u);	
		}else{//�Ѵ��ڣ�����ע��
			System.out.println("���û����Ѵ��ڣ�");
		}			
		return flag;
	}

	@Override
	public boolean updateById(User u) {
		 boolean flag = false;
			if(user.selectByName(u.getUsername()).getUsername() == null) {//�����ڣ��ɸ�
				user.updateById(u);
				flag = true;
				
			}else{//�Ѵ����û��������ɸ�
		        flag = false;
			}
		 
		return flag;
	}

	@Override
	public int login(String username, String password) {
		
		int flag = 0;
		String usertype = user.login(username, password);
		if(usertype.equals("�˿�")){
			System.out.println("��ӭ����¼������!");
			flag = 2;
		}
		else if(usertype.equals("��Ա")) {
			System.out.println("��ӭ��������Ա��");
			flag = 1;
		}else{
			System.err.println("�����ʽ��������û�������");
		}
		
		return flag;
	}

	
	
	@Override
	public boolean updateUserById(User u) {
		boolean flag = false;
		Scanner input = new Scanner(System.in);
		System.out.println("������userid��");
		int userid = input.nextInt();
		System.out.println("������username��");
		String username = input.next();
		System.out.println("������usertype��");
		String usertype = input.next();
		System.out.println("������password��");
		String password = input.next();
		System.out.println("������address��");
		String address = input.next();
		u.setUserid(userid);
		u.setUsername(username);
		u.setUsertype(usertype);
		u.setPassword(password);
		u.setAddress(address);
        flag = user.updateById(u);
        if(flag == false)
			System.out.println("���û������ڣ�"); 	
		if(flag == true)
			System.out.println("���û��޸ĳɹ���");
		return flag;
	}


	@Override
	public boolean deleteUser(int id) {
		// TODO Auto-generated method stub
		boolean flag = false;
		flag = user.deleteUser(id);
		if(flag == false)
				System.out.println("���û������ڣ�"); 	
			if(flag == true)
				System.out.println("���û�ɾ���ɹ���");
		return flag;
	}

	@Override
	public ArrayList<User> selectAllUser() {
		// TODO Auto-generated method stub
		
		return user.selectAllUser();
	}

	
	
}
