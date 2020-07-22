package com.lnsf.model;

public class Car {
    private int fid;
	private String fname;
	private int fprice;
	private int amount;
	
	public Car(){
		
	}
	
	public Car(int fid, String fname, int fprice, int amount) {
		super();
		this.fid = fid;
		this.fname = fname;
		this.fprice = fprice;
		this.amount = amount;
	}

	
	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public int getFprice() {
		return fprice;
	}
	public void setFprice(int fprice) {
		this.fprice = fprice;
	}

	
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "    " + fid + "    " + fname + "        " + fprice
				+ "      " + amount + "    ";
	}


	
	
	
	
}
