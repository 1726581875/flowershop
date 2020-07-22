package com.lnsf.model;

public class Market {
	
	private int mid;
	private int userid;
	private int mprice;
	private String mdate;
	private String address;
	

	
	public Market(){

	}

	public Market(int userid, int mprice, String mdate, String address) {
		super();
		this.userid = userid;
		this.mprice = mprice;
		this.mdate = mdate;
		this.address = address;
	}



	public int getMid() {
		return mid;
	}



	public void setMid(int mid) {
		this.mid = mid;
	}



	public int getUserid() {
		return userid;
	}



	public void setUserid(int userid) {
		this.userid = userid;
	}



	public int getMprice() {
		return mprice;
	}



	public void setMprice(int mprice) {
		this.mprice = mprice;
	}



	public String getMdate() {
		return mdate;
	}



	public void setMdate(String mdate) {
		this.mdate = mdate;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return " 订单号：" + mid + "   用户Id：" + userid + "   总价格："
				+ mprice + "   日期：" + mdate + "  地址：" + address + "  ";
	}

	
	
	
}
