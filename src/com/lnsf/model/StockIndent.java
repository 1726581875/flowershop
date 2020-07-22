package com.lnsf.model;

public class StockIndent {
	
	private int siid;
	private int fid;
	private int fprice;
	private int samount;
	private int sid;
	
	public StockIndent(){
		
	}
	
	
	public StockIndent(int siid, int fid, int fprice, int samount, int sid) {
		super();
		this.siid = siid;
		this.fid = fid;
		this.fprice = fprice;
		this.samount = samount;
		this.sid = sid;
	}


	public int getSiid() {
		return siid;
	}
	public void setSiid(int siid) {
		this.siid = siid;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public int getSamount() {
		return samount;
	}
	public void setSamount(int samount) {
		this.samount = samount;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	
	public int getFprice() {
		return fprice;
	}
	public void setFprice(int fprice) {
		this.fprice = fprice;
	}


	@Override
	public String toString() {
		return "StockIndent [siid=" + siid + ", fid=" + fid + ", fprice="
				+ fprice + ", samount=" + samount + ", sid=" + sid + "]";
	}

	
	
	
	
	
	
}
