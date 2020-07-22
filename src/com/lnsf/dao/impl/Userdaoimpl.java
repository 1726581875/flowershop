package com.lnsf.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.lnsf.DButils.DButil;
import com.lnsf.dao.Iuserdao;
import com.lnsf.model.User;

public class Userdaoimpl implements Iuserdao {

	@Override
	// *************该方法用于查全部用户信息，返回的是一个ArrayList数组*****************
	public ArrayList<User> selectAllUser() {

		ArrayList<User> list = new ArrayList<User>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DButil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from User");
			while (rs.next()) {
				User u = new User();
				u.setUserid(rs.getInt(1));
				u.setUsername(rs.getString(2));
				u.setUsertype(rs.getString(3));
				u.setPassword(rs.getString(4));
				u.setAddress(rs.getString(5));
				list.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DButil.closeConnection(rs, stmt, conn);
		}
		return list;
	}

	@Override
	// ***************该方法用于返回单个用户信息********************
	public User selectByName(String username) {
		User user = new User();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DButil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from User where username='" + username
					+ "'");
			while (rs.next()) {
				user.setUserid(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setUsertype(rs.getString(3));
				user.setPassword(rs.getString(4));
				user.setAddress(rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DButil.closeConnection(rs, stmt, conn);
		}

		return user;
	}

	@Override
	// ************登录方法，参数是用户名和密码，返回值是String类型的用户类型************
	public String login(String username, String password) {
		String uertype = "";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DButil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from user where username='"
					+ username + "' and password='" + password + "'");
			while (rs.next()) {
				uertype = rs.getString("usertype");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			DButil.closeConnection(rs, stmt, conn);

		}

		return uertype;
	}

	@Override
	// ***************************用于注册的方法*************************
	public int register(User u) {
		int flag = 0;
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			conn = DButil.getConnection();
			prep = conn.prepareStatement("insert into user(username,usertype,password,address) values(?,?,?,?)");
			prep.setString(1, u.getUsername());
			prep.setString(2, "顾客");
			prep.setString(3, u.getPassword());
			prep.setString(4, u.getAddress());
			if (prep.executeUpdate() == 1)
				flag = 1;// 增加用户成功
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			DButil.closeConnection(prep, conn);

		}

		return flag;
	}

	
//*********************该方法用于更新用户信息**********************
	@Override
	public boolean updateById(User u) {
		   boolean flag = false;
			
		Connection conn = null;
		PreparedStatement prep = null;
				
		try {
			conn = DButil.getConnection();
	    prep = conn.prepareStatement("update user set username = ?,usertype = ?,password = ? ,address=? where userid = ?");
		prep.setString(1,u.getUsername());
		prep.setString(2,u.getUsertype());
		prep.setString(3, u.getPassword());
		prep.setString(4, u.getAddress());
		prep.setInt(5,u.getUserid());
		if(prep.executeUpdate() == 1) flag = true;//修改成功
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
	@Override
	public boolean deleteUser(int id) {
		// TODO Auto-generated method stub
		boolean flag = false;

		Connection conn = null;
		conn = DButil.getConnection();
		PreparedStatement prep = null;
		PreparedStatement prep1 = null;
		PreparedStatement prep2 = null;
		ResultSet rs = null;
		try {
			prep = conn.prepareStatement("select * from user where userid = ?");
			prep.setInt(1, id);
			rs = prep.executeQuery();
			while (!rs.next()) {
				flag = false;
				return flag;
			}
			prep1 = conn.prepareStatement("delete from user where userid = ?");
			prep1.setInt(1, id);
			prep1.executeUpdate();
			flag = true;

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
            DButil.closeConnection(prep1, conn);
            DButil.closeConnection(prep2, conn);
            DButil.closeConnection(rs, prep, conn);
		}
		return flag;
	}



}
