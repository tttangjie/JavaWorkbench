package com.po;

public class Prepay {
	String pno;
	String premoney;

	public String getPno() {
		return pno;
	}

	public void setPno(String pno) {
		this.pno = pno;
	}

	public String getPremoney() {
		return premoney;
	}

	public void setPremoney(String premoney) {
		this.premoney = premoney;
	}

	@Override
	public String toString() {
		return "Prepay [pno=" + pno + ", premoney=" + premoney + "]";
	}

}
