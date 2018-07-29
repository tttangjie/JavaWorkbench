package com.tj.pojo;

public class Department {
	private String depno;
	private String depname;
	public String getDepno() {
		return depno;
	}
	public void setDepno(String depno) {
		this.depno = depno;
	}
	public String getDepname() {
		return depname;
	}
	public void setDepname(String depname) {
		this.depname = depname;
	}
	@Override
	public String toString() {
		return "Department [depno=" + depno + ", depname=" + depname + "]";
	}
}