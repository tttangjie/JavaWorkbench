package com.tj.pojo;

public class Medicine {
	private String mno;
	private String mname;
	private int mprice;
	public String getMno() {
		return mno;
	}
	public void setMno(String mno) {
		this.mno = mno;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public int getMprice() {
		return mprice;
	}
	public void setMprice(int mprice) {
		this.mprice = mprice;
	}
	@Override
	public String toString() {
		return "Medicine [mno=" + mno + ", mname=" + mname + ", mprice="
				+ mprice + "]";
	}
}
