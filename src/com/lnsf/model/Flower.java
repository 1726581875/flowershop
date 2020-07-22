package com.lnsf.model;

public class Flower {

	  
	private int fid;
	private String fname;
	private int fprice;
	private int famount;
	
	public Flower()
	{
		
	}
	
	public Flower(String fname, int fprice, int famount) {
		super();
		this.fname = fname;
		this.fprice = fprice;
		this.famount = famount;
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

	public int getFamount() {
		return famount;
	}

	public void setFamount(int famount) {
		this.famount = famount;
	}

	@Override
	public String toString() {
		return "     " + fid + "     " + fname + "     " + fprice
				+ "      " + famount + "    ";
	}
	
	
	
	
}
