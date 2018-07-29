package com.tj.pojo;

public class Bed {
	private String bno;
	private int condition;
	private int bprice;
	public String getBno() {
		return bno;
	}
	public void setBno(String bno) {
		this.bno = bno;
	}
	public int getCondition() {
		return condition;
	}
	public void setCondition(int condition) {
		this.condition = condition;
	}
	public int getBprice() {
		return bprice;
	}
	public void setBprice(int bprice) {
		this.bprice = bprice;
	}
	@Override
	public String toString() {
		return "Bed [bno=" + bno + ", condition=" + condition + ", bprice="
				+ bprice + "]";
	}
}
