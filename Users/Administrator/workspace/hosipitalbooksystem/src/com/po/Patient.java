package com.po;

public class Patient {
	String pno;
	String pname;
	String psex;
	String page;
	String pid;
	String ptel;
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
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
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
		return "Patient [pno=" + pno + ", pname=" + pname + ", psex=" + psex + ", page=" + page + ", pid=" + pid
				+ ", ptel=" + ptel + "]";
	}
	

}
