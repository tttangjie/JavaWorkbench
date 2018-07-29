package com.tj.pojo;

public class Patient {
	private String pno;
	private String pname;
	private String psex;
	private int page;
	private String pid;
	private String ptel;
	public String getPno() {
		return pno;
	}
	public void setPno(String pno) {
		this.pno = pno;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPsex() {
		return psex;
	}
	public void setPsex(String psex) {
		this.psex = psex;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPtel() {
		return ptel;
	}
	public void setPtel(String ptel) {
		this.ptel = ptel;
	}
	@Override
	public String toString() {
		return "Patient [pno=" + pno + ", pname=" + pname + ", psex=" + psex
				+ ", page=" + page + ", pid=" + pid + ", ptel=" + ptel + "]";
	}
}
