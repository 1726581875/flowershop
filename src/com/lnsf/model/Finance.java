package com.lnsf.model;

public class Finance {
	

	private String mid;
	private String sid;  
	private String fdate;
	private int benefit;
	

	
	public Finance(){
		
	}



	public Finance(String mid, String fdate, String sid, int benefit) {
		super();
		this.mid = mid;
		this.fdate = fdate;
		this.sid = sid;
		this.benefit = benefit;
	}



	public String getMid() {
		return mid;
	}



	public void setMid(String mid) {
		this.mid = mid;
	}



	public String getSid() {
		return sid;
	}



	public void setSid(String sid) {
		this.sid = sid;
	}



	public String getFdate() {
		return fdate;
	}



	public void setFdate(String fdate) {
		this.fdate = fdate;
	}



	public int getBenefit() {
		return benefit;
	}



	public void setBenefit(int benefit) {
		this.benefit = benefit;
	}
	
	

	

}
