package com.po;

public class Doctor {
	String dno;
	String dname;
	String dsex;
	String dage;
	String did;
	String dtel;
	String depno;

	public String getDno() {
		return dno;
	}

	public void setDno(String dno) {
		this.dno = dno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getDsex() {
		return dsex;
	}

	public void setDsex(String dsex) {
		this.dsex = dsex;
	}

	public String getDage() {
		return dage;
	}

	public void setDage(String dage) {
		this.dage = dage;
	}

	public String getDid() {
		return did;
	}

	public void setDid(String did) {
		this.did = did;
	}

	public String getDtel() {
		return dtel;
	}

	public void setDtel(String dtel) {
		this.dtel = dtel;
	}

	public String getDepno() {
		return depno;
	}

	public void setDepno(String depno) {
		this.depno = depno;
	}

	@Override
	public String toString() {
		return "Doctor [dno=" + dno + ", dname=" + dname + ", dsex=" + dsex + ", dage=" + dage + ", did=" + did
				+ ", dtel=" + dtel + ", depno=" + depno + "]";
	}

	

}
