package com.lnsf.model;

public class Indent {

	
	  private int iid;
	  private int fid;
	  private int mamount;
	  private int mid;
	  public Indent(){
	  
	  }
  	  
	public int getIid() {
		return iid;
	}



	public void setIid(int iid) {
		this.iid = iid;
	}



	public int getFid() {
		return fid;
	}



	public void setFid(int fid) {
		this.fid = fid;
	}



	public int getMamount() {
		return mamount;
	}



	public void setMamount(int mamount) {
		this.mamount = mamount;
	}



	public int getMid() {
		return mid;
	}



	public void setMid(int mid) {
		this.mid = mid;
	}



	@Override
	public String toString() {
		return "Indent [iid=" + iid + ", fid=" + fid + ", mamount=" + mamount
				+ ", mid=" + mid + "]";
	}

	  
	  
}
