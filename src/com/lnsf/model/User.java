package com.lnsf.model;

public class User {
     
	 private int userid;
	 private String username;
	  private String usertype;
	  private String password;
	  private String address;
	  
	  public User(){
		  
	  }
	  
	public User(String username, String usertype, String password,
			String address) {
		super();
		this.username = username;
		this.usertype = usertype;
		this.password = password;
		this.address = address;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public int getUserid() {
		return userid;
	}
	
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "用户id:" + userid + "     用户名：" + username
				+ "    类型：" + usertype + "    密码：" + password
				+ "   地址：" + address + "  ";
	}

	
	
}
