package com.lnsf.model;

public class Stock {

	
	
	private int sid;
	private String sdate;
	
	private int sprice;

	
	public Stock(){
		
	}

	

	public Stock(int sid, String sdate, int sprice) {
		super();
		this.sid = sid;
		this.sdate = sdate;
		this.sprice = sprice;
	}



	public int getSid() {
		return sid;
	}


	public void setSid(int sid) {
		this.sid = sid;
	}


	public String getSdate() {
		return sdate;
	}


	public void setSdate(String sdate) {
		this.sdate = sdate;
	}


	public int getSprice() {
		return sprice;
	}


	public void setSprice(int sprice) {
		this.sprice = sprice;
	}



	@Override
	public String toString() {
		return "����id��" + sid + "   ���ڣ�" + sdate + "   �ܼ۸�" + sprice
				;
	}
	
	
	
	

}
