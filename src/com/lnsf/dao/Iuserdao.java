package com.lnsf.dao;

import java.util.ArrayList;
import com.lnsf.model.User;

public interface Iuserdao {
     
      abstract User selectByName(String username);//�����û����鵥����Ϣ
     // abstract boolean selectByName(String username);//�����û����鵥����Ϣ�ж��Ƿ����
      abstract ArrayList<User> selectAllUser();//��ȫ����Ϣ
      abstract String login(String username,String password);//�û���¼�ж�
	  abstract int register(User u);//ע���û�
	  abstract boolean updateById(User u);//�����û���Ϣ
	  boolean deleteUser(int id);
}
