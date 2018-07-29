package com.po;

public class MedicalCase {
	private String pno;
	private String dno;
	private String mno;
	private String bno;
	private int cday;
	public String getPno() {
		return pno;
	}
	public void setPno(String pno) {
		this.pno = pno;
	}
	public String getDno() {
		return dno;
	}
	public void setDno(String dno) {
		this.dno = dno;
	}
	public String getMno() {
		return mno;
	}
	public void setMno(String mno) {
		this.mno = mno;
	}
	public String getBno() {
		return bno;
	}
	public void setBno(String bno) {
		this.bno = bno;
	}
	public int getDay() {
		return cday;
	}
	public void setDay(int day) {
		this.cday = day;
	}
	@Override
	public String toString() {
		return "Case [pno=" + pno + ", dno=" + dno + ", mno=" + mno + ", bno=" + bno + ", day=" + cday + "]";
	}

}
