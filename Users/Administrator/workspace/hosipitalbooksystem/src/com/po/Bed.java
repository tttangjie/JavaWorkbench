package com.po;

public class Bed {
	String bno;
	String bcondition;
	int bprice;
	public String getBno() {
		return bno;
	}
	public void setBno(String bno) {
		this.bno = bno;
	}
	public String getCondition() {
		return bcondition;
	}
	public void setCondition(String condition) {
		this.bcondition = condition;
	}
	public int getBprice() {
		return bprice;
	}
	public void setBprice(int bprice) {
		this.bprice = bprice;
	}
	@Override
	public String toString() {
		return "Bed [bno=" + bno + ", condition=" + bcondition + ", bprice=" + bprice + "]";
	}

	
}
